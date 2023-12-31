package learn.fan_site.controllers;

import learn.fan_site.data.S3FileRepository;
import learn.fan_site.domain.FileService;
import learn.fan_site.domain.Result;
import learn.fan_site.models.ImageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import learn.fan_site.domain.FileService;

import java.util.List;

@RestController
@CrossOrigin // (origins = "http://localhost:3000")
@RequestMapping("/api/file")


public class FileController {

    private final FileService service;

    public FileController(FileService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<Object> upload(@RequestParam("file") MultipartFile file, @RequestParam("description") String description) {
        Result<String> result = service.uploadFile(file, description);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result.getPayload(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(result.getMessages(), HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<List<ImageData>> getAllImages() {
        List<ImageData> images = service.fetchAllImages();
        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    @GetMapping("/home")
    public String getHomePage(Model model) {
        List<ImageData> images = service.fetchAllImages();
        model.addAttribute("images", images);
        return "home";
    }


//    @RestController
//    @RequestMapping("/api/images")
//    public class ImageController {
//
//        @Autowired
//        private S3FileRepository s3Repository;
//
//
//        @GetMapping
//        public List<ImageData> getImages() {
//        return s3Repository.fetchAllImages();
//        }
//
//    }

}
