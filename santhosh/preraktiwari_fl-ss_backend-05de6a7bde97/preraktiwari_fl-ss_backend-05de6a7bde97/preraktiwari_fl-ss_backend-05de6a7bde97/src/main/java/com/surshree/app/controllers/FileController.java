package com.surshree.app.controllers;

import com.surshree.app.domain.entities.FileContentEntity;
import com.surshree.app.models.file.UploadFileResponse;
import com.surshree.app.services.FileService;
import com.surshree.app.util.ControllerUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
public class FileController {
    @Autowired
    private FileService fileService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/file")
    public ResponseEntity<UploadFileResponse> uploadFile(@RequestParam("file") MultipartFile file) {
        FileContentEntity storedFile = fileService.storeFile(file);
        String fileDownloadUri = ControllerUtils.getResourceUrl("/{fileId}", storedFile.getFileContentId().toString()).toString();
        log.info("File download URL --> " + fileDownloadUri);
        return ResponseEntity.ok((new UploadFileResponse(storedFile.getFileName(), fileDownloadUri, file.getContentType(), file.getSize(), storedFile.getFileContentId().toString())));
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/file/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {
        FileContentEntity fileEntity = fileService.getFile(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(fileEntity.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileEntity.getFileName() + "\"")
                .body(new ByteArrayResource(fileEntity.getFileData()));
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/file/{fileId}")
    public ResponseEntity deleteFile(@PathVariable String fileId) {
        this.fileService.deleteFile(fileId);
        return ResponseEntity.ok().build();
    }
}
