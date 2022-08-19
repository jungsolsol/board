package soccer.board.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
@Getter
@NoArgsConstructor
public class MemberDetails {
    @Enumerated(EnumType.STRING)
    private MemberPosition memberPosition;
    @Embedded
    private Address Address;
    @Enumerated(EnumType.STRING)
    private Status status;

    public MemberDetails(MemberPosition memberPosition, soccer.board.domain.Address address, Status status) {
        this.memberPosition = memberPosition;
        Address = address;
        this.status = status;
    }
}
