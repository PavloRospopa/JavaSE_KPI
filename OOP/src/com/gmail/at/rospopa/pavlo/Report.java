package com.gmail.at.rospopa.pavlo;

import java.time.LocalDateTime;

public class Report {
    private Long id;
    SkiPass skiPass;
    LocalDateTime processDate;
    boolean validated;

    public Report(SkiPass skiPass, LocalDateTime processDate, boolean validated) {
        this.skiPass = skiPass;
        this.processDate = processDate;
        this.validated = validated;
    }

    public SkiPass getSkiPass() {
        return skiPass;
    }

    public LocalDateTime getProcessDate() {
        return processDate;
    }

    public boolean isValidated() {
        return validated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (this.id == null)
            this.id = id;
    }

    @Override
    public String toString() {
        return "Report{" +
                "ski-pass id=" + skiPass.getId() +
                ", type=" + skiPass.getType() +
                ", owner='" + skiPass.getOwner() + '\'' +
                ", process date=" + processDate +
                ", result of processing=" + ((validated) ? "\'processed successfully\'" : "\'validation failed\'") +
                '}';
    }
}
