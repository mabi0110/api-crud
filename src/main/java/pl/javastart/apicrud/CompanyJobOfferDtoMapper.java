package pl.javastart.apicrud;

import org.springframework.stereotype.Service;

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
