package soccer.board.domain;

import lombok.Getter;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
@Getter
public class MemberDetails {
    @Enumerated(EnumType.STRING)
    private MemberPosition memberPosition;
    @Embedded
    private Address Address;
    @Enumerated(EnumType.STRING)
    private Status status;

}
