package co.develhope.esercizio10.services;

import co.develhope.esercizio10.entities.FileEntity;
import co.develhope.esercizio10.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

@Service
public class FileService {
    @Autowired
    private FileRepository fileRepository;

    public FileEntity uploadFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        FileEntity fileEntity = new FileEntity();
        fileEntity.setFileName(fileName);

        File convertFile = new File("path/to/save/" + fileName);
        convertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        fout.close();

        return fileRepository.save(fileEntity);
    }
    public Optional<FileEntity> getFileById(Long id) {
        return fileRepository.findById(id);
    }
}
