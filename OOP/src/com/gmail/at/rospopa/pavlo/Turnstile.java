package com.gmail.at.rospopa.pavlo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Turnstile {
    private SkiPassSystem skiPassSystem;
    private List<Report> reports = new ArrayList<>();
    private static long nextId = 0;

    private long getNextId() {
        return nextId++;
    }

    public Turnstile(SkiPassSystem skiPassSystem) {
        this.skiPassSystem = skiPassSystem;
    }

    public SkiPassSystem getSkiPassSystem() {
        return skiPassSystem;
    }

    public boolean processSkiPass(SkiPass skiPass){
        boolean validated = true;
        if (!skiPassSystem.validateSkiPass(skiPass))
            validated = false;
        else if (skiPass instanceof SkiPassWithLimitedLifts) {
            ((SkiPassWithLimitedLifts) skiPass).decrementNumberOfLifts();
        }
        this.generateReport(skiPass, validated);
        return validated;
    }

    private Report generateReport(SkiPass skiPass, boolean validated){
        Report report = new Report(skiPass, LocalDateTime.now(), validated);
        report.setId(getNextId());
        reports.add(report);
        return report;
    }

    public List<Report> getAllReports(){
        return reports;
    }

    public List<Report> getReportsBySkiPassType(SkiPassType type){
        return reports.stream().filter(report -> report.getSkiPass().getType() == type).collect(Collectors.toList());
    }
}
