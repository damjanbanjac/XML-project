package com.microservices.ads.controller;

import com.microservices.ads.dto.AdCarDTO;
import com.microservices.ads.dto.ProbaDTO;
import com.microservices.ads.dto.request.AdCarRequest;
import com.microservices.ads.dto.response.AdCarResponse;
import com.microservices.ads.dto.response.ImageResponse;
import com.microservices.ads.model.CarBrand;
import com.microservices.ads.model.CarModel;
import com.microservices.ads.model.Image;
import com.microservices.ads.repository.ICarBrandRepository;
import com.microservices.ads.repository.ICarModelRepository;
import com.microservices.ads.repository.ImageRepository;
import com.microservices.ads.service.ICarModelService;
import com.microservices.ads.service.implementation.AdCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/ads")
public class AdCarController {


    @Autowired
    private AdCarService adsCarService;

    @Autowired
    private ImageRepository imageRepository;




    @PostMapping("/{id}/user")
    public AdCarResponse addAd(@RequestBody AdCarRequest request,@PathVariable long id) throws Exception{
        System.out.println("user id" + id);
        return adsCarService.createAd(request,id);
    }

//    @PostMapping("/{id}/user")
//    public AdCarDTO addAd(@RequestBody AdCarDTO request, @PathVariable long id) throws Exception{
//        System.out.println("user id" + id);
//        return adsCarService.createSearchAd(request,id);
//    }

    @PostMapping("/{id}/agent")
    public AdCarResponse addAdAgent(@RequestBody AdCarRequest request,@PathVariable long id) throws Exception{
        System.out.println("GETONE");
        return adsCarService.createAdAgent(request,id);
    }

    @PutMapping("/{id}/ad")
    public AdCarResponse updateAd(@RequestBody AdCarRequest request, @PathVariable long id) throws Exception{
        return adsCarService.updateAd(request, id);
    }

    @DeleteMapping("/{id}/ad")
    public void deleteAd(@PathVariable long id) throws Exception{
        adsCarService.deleteAdCar(id);
    }

    @GetMapping("/{id}/ad")
    public AdCarResponse getAd(@PathVariable long id) throws Exception{
        return adsCarService.getAd(id);
    }
    @GetMapping
    public List<AdCarResponse> getAllAds() throws Exception{
        System.out.println("GETALL");
        return adsCarService.getAllAds();
    }

//    @GetMapping
//    public String getAllAds() throws Exception{
//        System.out.println("GETALL");
//        return "Lepa sela lepo gore";
//    }

    @Autowired
    ICarBrandRepository iCarBrandRepository;

    @Autowired
    ICarModelRepository iCarModelRepository;

//    @GetMapping
//    public CarBrand getAllAds() throws Exception{
//        List<CarBrand> carBrands = iCarBrandRepository.findAll();
//        CarBrand one = null;
//        for(CarBrand carBrand : carBrands) {
//            if(carBrand != null) {
//                one = carBrand;
//            }
//        }
//        return one;
//    }

//    @GetMapping
//    public ProbaDTO getAllAds() throws Exception{
//        CarBrand carBrand = iCarBrandRepository.findOneById(2);
//        CarModel carModel = iCarModelRepository.findOneById((long)1);
//        ProbaDTO proba = new ProbaDTO(carBrand,carModel);
//        return proba;
//    }

    @GetMapping("/{id}/user")
    public List<AdCarResponse> getAllAdsFromUser(@PathVariable long id) throws Exception{
        return adsCarService.getAllAdsUser(id);
    }

    @GetMapping("/{id}/agent")
    public List<AdCarResponse> getAllAdsFromAgent(@PathVariable long id) throws Exception{
        return adsCarService.getAllAdsAgent(id);
    }

    @GetMapping("/{id}/image")
    public List<ImageResponse> getImage(@PathVariable("id") String id) throws IOException {
        Long idCar  = Long.parseLong(id);
        Image retrievedImage = new Image();
        List<Image> allImages = imageRepository.findAll();
        List<ImageResponse> allResponse = new ArrayList<>();

        for (Image image: allImages ) {
            if(image.getAdCar().getId() == idCar) {
                System.out.println("usao");
                ImageResponse imageResponse = new ImageResponse(image);
                allResponse.add(imageResponse);


            }

        }

        // Image img = new Image(retrievedImage.getName(), retrievedImage.getType(),
        //   retrievedImage.getPic());
        // System.out.println(img.getAdCar());
        // System.out.println(img.getPic());
        //ImageResponse imageResponse = new ImageResponse(img);
        return allResponse;

    }
}
