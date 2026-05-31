package pl.javastart.apicrud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class JobOfferController {

    private final JobOfferService jobOfferService;

    public JobOfferController(JobOfferService jobOfferService) {
        this.jobOfferService = jobOfferService;
    }


    @GetMapping("/offers/{id}")
    Optional<JobOfferDto> getJobOfferById(@PathVariable Long id) {
        return jobOfferService.getJobOfferById(id);
    }
}
