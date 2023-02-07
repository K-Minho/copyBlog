package shop.mtcoding.blog.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;

import shop.mtcoding.blog.dto.board.BoardResp;
import shop.mtcoding.blog.dto.board.BoardResp.BoardDetailRespDto;
import shop.mtcoding.blog.model.User;

// 통합테스트
// mock(모조) 환경의 ioc컨테이너에 bean이 생성
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
public class BoardControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private MockHttpSession session;

    @Autowired
    ObjectMapper om;

    @Test
    public void detail_test() throws Exception {
        // given
        int id = 1;
        // when
        ResultActions resultActions = mvc.perform(get("/board/" + id));
        Map<String, Object> map = resultActions.andReturn().getModelAndView().getModel();
        BoardDetailRespDto dto = (BoardDetailRespDto) map.get("dto");
        String model = om.writeValueAsString(dto);
        System.out.println("테스트 : " + model);
        System.out.println("테스트 : " + dto.getTitle());
        System.out.println("테스트 : " + dto.getContent());
        System.out.println("테스트 : " + dto.getUsername());
        // then
        resultActions.andExpect(status().is2xxSuccessful());
        assertThat(dto.getTitle()).isEqualTo("제목 1번");
        assertThat(dto.getUsername()).isEqualTo("ssar");
    }

    @Test
    public void main_test() throws Exception {
        // given
        // when
        ResultActions resultActions = mvc.perform(get("/"));
        Map<String, Object> map = resultActions.andReturn().getModelAndView().getModel();
        System.out.println(map);
        List<BoardResp.BoardListDto> dtos = (List<BoardResp.BoardListDto>) map.get("dtos");
        String model = om.writeValueAsString(dtos);
        System.out.println("test : " + model);

        // the
        resultActions.andExpect(status().is2xxSuccessful());
        assertThat(dtos.size()).isEqualTo(6);
        assertThat(dtos.get(1).getTitle()).isEqualTo("제목 2번");
        assertThat(dtos.get(3).getUsername()).isEqualTo("cos");
        assertThat(dtos.get(5).getUsername()).isEqualTo("love");
    }

    @Test
    public void save_test() throws Exception {
        // given
        String title = "";
        for (int i = 0; i < 49; i++) {
            title += "가";
        }
        // 아주긴 long 타입은 long.longValue를 통해 비교를 해야함.
        String requestBody = "title=" + title + "&content=2345";
        // when
        ResultActions resultActions = mvc.perform(post("/board").content(requestBody)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE).session(session));
        // then
        resultActions.andExpect(status().is3xxRedirection());
    }

}