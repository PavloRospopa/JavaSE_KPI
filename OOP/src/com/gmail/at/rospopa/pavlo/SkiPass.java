package com.gmail.at.rospopa.pavlo;

public abstract class SkiPass {
    private Long id;
    private final String owner;
    private final SkiPassType type;
    //private int numberOfLifts;
    //private final LocalDateTime activationDate;
    //private final LocalDateTime expirationDate;


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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SkiPass skiPass = (SkiPass) o;

        if (id != null ? !id.equals(skiPass.id) : skiPass.id != null) return false;
        if (owner != null ? !owner.equals(skiPass.owner) : skiPass.owner != null) return false;
        return type == skiPass.type;

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
