package org.springboot.board.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
//@Data
@Builder
@Entity(name = "TB_User")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String email;
    private LocalDateTime createdDt;
    private LocalDateTime updatedDt;

}
