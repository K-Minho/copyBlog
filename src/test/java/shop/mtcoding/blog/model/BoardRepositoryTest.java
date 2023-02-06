package shop.mtcoding.blog.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

import shop.mtcoding.blog.dto.board.BoardResp.BoardListDto;

@MybatisTest // Repository - Mybatis - DB 만 생성
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void findAllMainBoard_test() throws Exception {
        // given
        ObjectMapper om = new ObjectMapper();
        // when
        List<BoardListDto> boardListDto = boardRepository.findAllMainBoard();
        System.out.println("test size : " + boardListDto.size());
        String responseBody = om.writeValueAsString(boardListDto);
        System.out.println(responseBody);

        // then
        assertThat(boardListDto.get(5).getUsername()).isEqualTo("love");
    }
}
