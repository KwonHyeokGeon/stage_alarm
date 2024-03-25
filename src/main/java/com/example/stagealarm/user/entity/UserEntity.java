package com.example.stagealarm.user.entity;

import com.example.stagealarm.BaseEntity;
import com.example.stagealarm.artist.entity.ArtistLike;
import com.example.stagealarm.genre.entity.GenreSubscribe;
import com.example.stagealarm.user.dto.UserDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity {
  @Column(nullable = false, unique = true)
  private String loginId;
  @Column(nullable = false)
  @Setter
  private String password;
  @Column(nullable = false)
  @Setter
  private String email; //email로 가입여부 식별
  @Setter
  private String gender;
  @Setter
  private String phone;
  @Setter
  private String profileImg;
  @Setter
  private String address;
  @Setter
  private String authorities;

  @OneToMany(mappedBy = "userEntity")
  private List<ArtistLike> likeList;

  @OneToMany(mappedBy = "userEntity")
  private List<GenreSubscribe> genreSubscribeList;

  // authorities 빌더에서 값을 정하지 않음
  public static UserEntity fromDto(UserDto dto){
    return UserEntity.builder()
            .loginId(dto.getLoginId())
            .password(dto.getPassword())
            .email(dto.getEmail())
            .gender(dto.getGender())
            .phone(dto.getPhone())
            .profileImg(dto.getProfileImg())
            .address(dto.getAddress())
            .build();
  }
}
