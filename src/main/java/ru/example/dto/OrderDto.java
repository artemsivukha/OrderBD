package ru.example.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDateTime;

public class OrderDto implements Serializable {

    private String title;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "createdate")
    private LocalDateTime createDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "declinedate")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime declineDate;
    private OrganizationDto organizationDto;

    public OrderDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getDeclineDate() {
        return declineDate;
    }

    public void setDeclineDate(LocalDateTime declineDate) {
        this.declineDate = declineDate;
    }

    public OrganizationDto getOrganizationDto() {
        return organizationDto;
    }

    public void setOrganizationDto(OrganizationDto organizationDto) {
        this.organizationDto = organizationDto;
    }
}
