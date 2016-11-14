package com.gmail.at.rospopa.pavlo;

public abstract class SkiPass {
    private Long id;
    private final String owner;
    private final SkiPassType type;

    public SkiPass(String owner, SkiPassType type) {
        this.owner = owner;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public SkiPassType getType() {
        return type;
    }

    public void setId(Long id) {
        if (this.id == null)
            this.id = id;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;

        if (other instanceof SkiPass) {
            SkiPass that = (SkiPass) other;

            if (id != null ? !id.equals(that.id) : that.id != null) return false;
            if (owner != null ? !owner.equals(that.owner) : that.owner != null) return false;
            return type == that.type;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SkiPass{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", type=" + type +
                '}';
    }
}
