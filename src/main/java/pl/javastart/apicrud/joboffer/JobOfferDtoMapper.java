package pl.javastart.apicrud.joboffer;

import org.springframework.stereotype.Service;


@Service
public class JobOfferDtoMapper {

    JobOfferDto map(JobOffer jobOffer) {
        JobOfferDto jobOfferDto = new JobOfferDto();
        jobOfferDto.setId(jobOffer.getId());
        jobOfferDto.setTitle(jobOffer.getTitle());
        jobOfferDto.setDescription(jobOffer.getDescription());
        jobOfferDto.setRequirements(jobOffer.getRequirements());
        jobOfferDto.setDuties(jobOffer.getDuties());
        jobOfferDto.setLocation(jobOffer.getLocation());
        jobOfferDto.setMinSalary(jobOffer.getMinSalary());
        jobOfferDto.setMaxSalary(jobOffer.getMaxSalary());
        jobOfferDto.setDateAdded(jobOffer.getDateAdded());
        jobOfferDto.setCompanyId(jobOffer.getCompany().getId());
        jobOfferDto.setCompanyName(jobOffer.getCompany().getName());
        return jobOfferDto;
    }
}
