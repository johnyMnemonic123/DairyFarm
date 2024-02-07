package diaryfarm.domain;

import java.util.Objects;

public class Cow {
    final Long cowId;
    final String nickName;
    final Long parentCowId;

    public Cow(Long cowId, String nickName, Long parentCowId) {
        this.cowId = cowId;
        this.nickName = nickName;
        this.parentCowId = parentCowId;
    }

    public Long getCowId() {
        return cowId;
    }

    public String getNickName() {
        return nickName;
    }

    public Long getParentCowId() {
        return parentCowId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cow cow = (Cow) o;
        return Objects.equals(cowId, cow.cowId) && Objects.equals(nickName, cow.nickName) && Objects.equals(parentCowId, cow.parentCowId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cowId, nickName, parentCowId);
    }

    //todo fancy toString()
    @Override
    public String toString() {
        return "Cow{" +
                "cowId=" + cowId +
                ", nickName='" + nickName + '\'' +
                ", parentCowId=" + parentCowId +
                '}';
    }
}
