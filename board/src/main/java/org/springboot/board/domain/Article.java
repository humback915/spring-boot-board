package org.springboot.board.domain;

import lombok.*;
import org.springframework.boot.actuate.endpoint.web.Link;
import org.springframework.core.annotation.Order;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 게시글
 */
@Getter
@ToString
@Table(indexes ={
        @Index(columnList = "title"),
        @Index(columnList = "hashtag"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@Entity
// @EntityListeners(AuditingEntityListener.class) AuditingFields.java
public class Article extends AuditingFields{

    /** Lombok 기능인 @NoArgsConstructor(AccessLevel.PROTECTED) 처리 가능 */
    protected Article(){}    /** 기본 생성자 접근 방지 */

    private Article(String title, String content, String hashtag) {
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
    }
    /** 위의 필요 생성자를 private로 막고 static 타입의 factory method 형식의 of()메소드 사용 */
    public static Article of(String title, String content, String hashtag) {
        return new Article(title, content, hashtag);
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; /** 게시글ID */

    @Setter @Column(nullable = false)
    private String title; /** 제목 */
    @Setter @Column(nullable = false, length = 10000)
    private String content; /** 내용 */

    @Setter
    private String hashtag; /** 해시태그 */

    @ToString.Exclude
    @OrderBy("id")
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private final Set<ArticleComment> articleComments = new LinkedHashSet<>();

//    @CreatedDate @Column(nullable = false)
//    private LocalDateTime createdAt; /** 생성일시 */
//    @CreatedBy @Column(nullable = false, length = 100)
//    private String createdBy; /** 생성자 */
//    @LastModifiedDate @Column(nullable = false)
//    private LocalDateTime modifiedAt; /** 수정일시 */
//    @LastModifiedBy @Column(nullable = false, length = 100)
//    private String modifiedBy; /** 수정자 */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article article)) return false;
        return id != null && id.equals(article.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
