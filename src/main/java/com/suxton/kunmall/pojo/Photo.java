package com.suxton.kunmall.pojo;

public class Photo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Photo.id
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Photo.moment_id
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    private Integer momentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Photo.photo
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    private byte[] photo;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Photo.id
     *
     * @return the value of Photo.id
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Photo.id
     *
     * @param id the value for Photo.id
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Photo.moment_id
     *
     * @return the value of Photo.moment_id
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    public Integer getMomentId() {
        return momentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Photo.moment_id
     *
     * @param momentId the value for Photo.moment_id
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    public void setMomentId(Integer momentId) {
        this.momentId = momentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Photo.photo
     *
     * @return the value of Photo.photo
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    public byte[] getPhoto() {
        return photo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Photo.photo
     *
     * @param photo the value for Photo.photo
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}