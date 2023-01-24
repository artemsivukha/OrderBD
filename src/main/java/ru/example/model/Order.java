package ru.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import ru.example.dto.OrderDto;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "ord")
public class Order implements Serializable {

    private static final long serialVersionUID = -8095039359436728475L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "createdate")
    private LocalDateTime createDate;
    @Column(name = "declinedate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime declineDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    public Order() {
    }

    public Order(String title, LocalDateTime createDate, LocalDateTime declineDate) {
        this.title = title;
        this.createDate = createDate;
        this.declineDate = declineDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
