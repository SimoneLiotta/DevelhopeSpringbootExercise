package co.develhope.esercizio10.controllers;

import co.develhope.esercizio10.entities.FileEntity;
import co.develhope.esercizio10.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        FileEntity uploadedFile = fileService.uploadFile(file);
        return ResponseEntity.created(URI.create("/api/files/" + uploadedFile.getId())).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FileEntity> getFile(@PathVariable Long id) {
        Optional<FileEntity> fileEntityOptional = fileService.getFileById(id);
        return fileEntityOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
