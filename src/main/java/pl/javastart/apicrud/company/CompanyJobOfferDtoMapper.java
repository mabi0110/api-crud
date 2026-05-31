package pl.javastart.apicrud.company;

import org.springframework.stereotype.Service;
import pl.javastart.apicrud.joboffer.JobOffer;

@Service
public class CompanyJobOfferDtoMapper {

    CompanyJobOfferDto map (JobOffer jobOffer) {
        CompanyJobOfferDto companyJobOfferDto = new CompanyJobOfferDto();
        companyJobOfferDto.setId(jobOffer.getId());
        companyJobOfferDto.setTitle(jobOffer.getTitle());
        companyJobOfferDto.setLocation(jobOffer.getLocation());
        companyJobOfferDto.setMinSalary(jobOffer.getMinSalary());
        companyJobOfferDto.setMaxSalary(jobOffer.getMaxSalary());
        return companyJobOfferDto;
    }
}
