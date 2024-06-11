package org.springboot.board.domain;

import lombok.Cleanup;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 댓글
 */
@Getter
@ToString
@Table(indexes ={
        @Index(columnList = "content"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
// @EntityListeners(AuditingEntityListener.class) AuditingFields.java
@Entity
public class ArticleComment extends AuditingFields{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; /** 게시글ID */

    @Setter @ManyToOne(optional = false)
    private Article article; /** 게시글참조 */
    @Setter @Column(nullable = false, length = 500)
    private String content; /** 내용 */

//    @CreatedDate @Column(nullable = false)
//    private LocalDateTime createdAt; /** 생성일시 */
//    @CreatedBy @Column(nullable = false, length = 100)
//    private String createdBy; /** 생성자 */
//    @LastModifiedDate @Column(nullable = false)
//    private LocalDateTime modifiedAt; /** 수정일시 */
//    @LastModifiedBy @Column(nullable = false, length = 100)
//    private String modifiedBy; /** 수정자 */

    /** Lombok 기능인 @NoArgsConstructor(AccessLevel.PROTECTED) 처리 가능 */
    protected ArticleComment() { /** 기본 생성자 접근 방지 */
    }
    private ArticleComment(Article article, String content) {
        this.article = article;
        this.content = content;
    }
    /** 위의 필요 생성자를 private로 막고 static 타입의 factory method 형식의 of()메소드 사용 */
    public static ArticleComment of(Article article, String content) {
        return new ArticleComment(article, content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArticleComment that)) return false;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
