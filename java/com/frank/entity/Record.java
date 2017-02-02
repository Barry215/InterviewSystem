package com.frank.entity;

public class Record {
    private Integer recordId;

    private Integer sectionId;

    private Integer sId;

    private String sName;

    private String looksRemark;

    private String characterRemark;

    private String abilityRemark;

    private String otherRemark;

    private Integer compositeScore;

    private String timeUsed;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName == null ? null : sName.trim();
    }

    public String getLooksRemark() {
        return looksRemark;
    }

    public void setLooksRemark(String looksRemark) {
        this.looksRemark = looksRemark == null ? null : looksRemark.trim();
    }

    public String getCharacterRemark() {
        return characterRemark;
    }

    public void setCharacterRemark(String characterRemark) {
        this.characterRemark = characterRemark == null ? null : characterRemark.trim();
    }

    public String getAbilityRemark() {
        return abilityRemark;
    }

    public void setAbilityRemark(String abilityRemark) {
        this.abilityRemark = abilityRemark == null ? null : abilityRemark.trim();
    }

    public String getOtherRemark() {
        return otherRemark;
    }

    public void setOtherRemark(String otherRemark) {
        this.otherRemark = otherRemark == null ? null : otherRemark.trim();
    }

    public Integer getCompositeScore() {
        return compositeScore;
    }

    public void setCompositeScore(Integer compositeScore) {
        this.compositeScore = compositeScore;
    }

    public String getTimeUsed() {
        return timeUsed;
    }

    public void setTimeUsed(String timeUsed) {
        this.timeUsed = timeUsed == null ? null : timeUsed.trim();
    }
}