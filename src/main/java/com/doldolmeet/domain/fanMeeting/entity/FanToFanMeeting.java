package com.doldolmeet.domain.fanMeeting.entity;

import com.doldolmeet.domain.users.fan.entity.Fan;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class FanToFanMeeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    // 팬
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fan_id", referencedColumnName = "id")
    private Fan fan;

    // 팬미팅
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fan_meeting_id", referencedColumnName = "id")
    private FanMeeting fanMeeting;

    // 신청 상태
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private FanMeetingApplyStatus fanMeetingApplyStatus;

    // 팬이 팬미팅에 참여하는 순서
    @Column(nullable = false)
    private Integer orderNumber;

    public void setUserAndFanMeeting(Fan fan, FanMeeting fanMeeting, Integer orderNumber) {
        this.fan = fan;
        this.fanMeeting = fanMeeting;
        this.orderNumber = orderNumber;
    }
}
