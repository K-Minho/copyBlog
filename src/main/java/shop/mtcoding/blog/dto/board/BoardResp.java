package shop.mtcoding.blog.dto.board;

import lombok.Getter;
import lombok.Setter;

public class BoardResp {

    @Setter
    @Getter
    public static class BoardListDto {
        private int id;
        private String title;
        private String username;
        // private String thumbnail;
    }

    @Setter
    @Getter
    public static class BoardDetailRespDto {
        private int id;
        private String title;
        private String content;
        private int userId;
        private String username;
    }
}
