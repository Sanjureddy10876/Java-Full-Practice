package com.surshree.app.services;

import com.surshree.app.domain.entities.FileContentEntity;
import com.surshree.app.exception.CustomFileNotFoundException;
import com.surshree.app.exception.FileStorageException;
import com.surshree.app.repository.FileContentRepo;
import com.surshree.app.util.UserContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
@Slf4j
public class FileService {

    @Autowired
    private FileContentRepo fileRepo;

    public FileContentEntity storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            FileContentEntity fileEntity = new FileContentEntity();
            fileEntity.setFileName(fileName);
            fileEntity.setFileType(file.getContentType());
            fileEntity.setFileData(file.getBytes());

            String userId = UserContext.getLoggedInUserId();
            if(userId == null || userId.equals("anonymousUser")){
                fileEntity.setCreatedBy("anonymous");
                fileEntity.setUpdatedBy("anonymous");
                fileEntity.setUseCustomUserId(true);
            }

            return fileRepo.save(fileEntity);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public FileContentEntity getFile(String fileId) {
        return fileRepo
                .findById(UUID.fromString(fileId))
                .orElseThrow(() -> new CustomFileNotFoundException("File not found with id " + fileId));
    }

    public void deleteFile(String fileId){
        try {
            this.fileRepo.deleteById(UUID.fromString(fileId));
        }catch (EmptyResultDataAccessException e){
            log.error("No Record Exist with ID " + fileId, e);
        }
    }
}
