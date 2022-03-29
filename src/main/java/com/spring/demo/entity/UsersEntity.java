package com.spring.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users", schema = "heroku_8824700dd65d660")
public class UsersEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    @Schema(example = "4", required = true)
    private Integer id;

    @Column(name = "user_name")
    @Schema(example = "Admin", required = true)
    private String userName;

    @Column(name = "pass_word")
    @Schema(example = "123456", required = true)
    private String passWord;

    @Schema(example = "phuc@gmail.com", required = true)
    private String email;

    @Schema(example = "image", required = true)
    private String image;

    @Column(name = "full_name")
    @Schema(example = "Nguyễn Bá Phúc", required = true)
    private String fullName;

    @Schema(example = "123456789", required = true)
    private String phone;

    @Schema(example = "123456789", required = true)
    private String skype;

    @Schema(example = "ghi chú", required = true)
    private String about;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "creditUser")
    private List<CreditCardEntity> creditCard = new ArrayList<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "jobPostUser")
    private List<JobPostingEntity> jobPostings = new ArrayList<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "visaUsers")
    private List<VisaCardEntity> visaCard = new ArrayList<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usersJobApplication")
    private List<JobApplicationEntity> jobApplications = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<RolesEntity> roles = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "my_skill",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<CategoriesEntity> mySkills = new ArrayList<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<ReviewsEntity> emlpoyeeReviews = new ArrayList<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "custom")
    private List<ReviewsEntity> customReviews = new ArrayList<>();

    //Room
    @JsonIgnore
    @OneToMany(mappedBy = "userSend")
    private List<RoomEntity> roomsSend = new ArrayList<>();

    @JsonIgnore
    @OneToOne(mappedBy = "userTake")
    private RoomEntity roomTake;


}
