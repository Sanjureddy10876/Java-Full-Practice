package com.surshree.app.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "T_SUBMITTED_ENTRIES")
@NamedQueries({
        @NamedQuery(name = "SubmittedEntriesEntity.findByUserId", query = "from SubmittedEntriesEntity se join fetch se.userEntity ue join fetch se.competitionEntity ce where ue.userId = :userId and ce.isActive = '1'"),
        @NamedQuery(name = "SubmittedEntriesEntity.findByCompetitionId", query = "from SubmittedEntriesEntity se join fetch se.competitionEntity ce where ce.competitionId = :competitionId and se.fileId is not null"),
        @NamedQuery(name = "SubmittedEntriesEntity.findByCompetitionIdAndIsShortlisted", query = "from SubmittedEntriesEntity se join fetch se.competitionEntity ce where ce.competitionId = :competitionId and se.isShortlisted = '1'"),
        @NamedQuery(name = "SubmittedEntriesEntity.findByCompetitionIdAndIsWinnerAnnounced", query = "from SubmittedEntriesEntity se join fetch se.competitionEntity ce where ce.competitionId = :competitionId and ce.isWinnerAnnounced = '1' and se.isWinner = '1'"),
        @NamedQuery(name = "SubmittedEntriesEntity.findAllByIsWinnerAnnounced", query = "from SubmittedEntriesEntity se join fetch se.competitionEntity ce where ce.isWinnerAnnounced = '1' and se.isWinner = '1'")
})
public class SubmittedEntriesEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SUBMITTED_ENTRIES_ID")
    private Long submittedEntriesId;

    @OneToOne
    @JoinColumn(name = "COMPETITION_ID")
    private CompetitionEntity competitionEntity;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity userEntity;

    @JoinColumn(name = "FILE_ID")
    private UUID fileId;

    @JoinColumn(name = "IS_SHORTLISTED")
    private String isShortlisted;

    @JoinColumn(name = "IS_WINNER")
    private String isWinner;

    @JoinColumn(name = "PRICE_WON")
    private BigDecimal priceWon;

    @JoinColumn(name = "WINNER_DESC")
    private String winnerDesc;
}
