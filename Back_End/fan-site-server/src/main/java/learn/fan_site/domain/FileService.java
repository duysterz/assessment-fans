package learn.fan_site.domain;

import learn.fan_site.data.FileRepository;
import learn.fan_site.exceptions.FileUploadException;
import learn.fan_site.models.ImageData;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class FileService {

    private final FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public Result<String> uploadFile(MultipartFile file, String description) {
        Result<String> result = new Result<>();
        try {
            result.setPayload(fileRepository.upload(file, description));
        } catch (FileUploadException ex) {
            ex.printStackTrace();
            result.addMessage("File not uploaded.", ResultType.INVALID);
        }
        return result;
    }
    public List<ImageData> fetchAllImages() {
        return fileRepository.fetchAllImages();
    }
}


            //            result.setPayload(fileRepository.upload(file));
//        } catch (FileUploadException ex) {
//            ex.printStackTrace();
//            result.addMessage("File not uploaded.", ResultType.INVALID);
//        }
//        return result;
//    }
//}
