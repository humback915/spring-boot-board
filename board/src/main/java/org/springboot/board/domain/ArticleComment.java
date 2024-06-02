package org.springboot.board.domain;

import java.time.LocalDateTime;

/**
 * 댓글
 */
public class ArticleComment {
    private Long id; /** 게시글ID */
    private Article article; /** 게시글참조 */
    private String title; /** 제목 */
    private String content; /** 내용 */

    private LocalDateTime createdAt; /** 생성일시 */
    private String createdBy; /** 생성자 */
    private LocalDateTime modifiedAt; /** 수정일시 */
    private String modifiedBy; /** 수정자 */
}
