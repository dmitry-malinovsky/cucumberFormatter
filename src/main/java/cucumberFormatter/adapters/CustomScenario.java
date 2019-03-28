package cucumberFormatter.adapters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import gherkin.formatter.model.Scenario;
import gherkin.formatter.model.Tag;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static cucumberFormatter.adapters.Status.*;

public class CustomScenario {
    private String name;
    private LocalDate date;
    private List<Tag> tags;
    private Status status;
    private String output;
    private List<CustomStep> steps = new ArrayList<>();
    private long duration;
    private final String build = System.getProperty("jenkins.build.number");
    private final String job = System.getProperty("jenkins.job.name");


    public CustomScenario(Scenario scenario) {
        this.name = scenario.getName();
        this.date = LocalDate.now();
        this.tags = scenario.getTags();
        this.status = PASSED;
    }

    public void addStep(CustomStep step) {
        if (!step.getStatus().equals(SKIPPED)) {
            this.steps.add(step);
            this.duration += step.getDuration();
            if (step.getStatus().equals(FAILED) || step.getStatus().equals(SKIPPED)) {
                this.status = FAILED;
                this.output = step.getOutput();
            }
        }
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public Status getStatus() {
        return status;
    }

    public String getOutput() {
        return output;
    }

    public List<CustomStep> getSteps() {
        return steps;
    }

    public long getDuration() {
        return duration;
    }

    public String getBuild() {
        return build;
    }

    public String getJob() {
        return job;
    }

    public String toJson(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
