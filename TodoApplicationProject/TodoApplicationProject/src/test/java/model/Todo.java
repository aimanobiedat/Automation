package model;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Todo {
    @JsonProperty("isCompleted")
    private Boolean isCompleted;

    @JsonProperty("_id")
    private String id;
    private String item;
    private String userID;
    private String createdAt;
    @JsonProperty("__v")
    private String v;
    public Todo(){

    }
    public Todo(Boolean isCompleted , String item){


        this.isCompleted=isCompleted;
        this.item=item;
    }


    public Todo(String item){

        this.item=item;
    }
    public Boolean getisCompleted() {
        return isCompleted;
    }

    public void setisCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getId() {
        return id;
    }

    @JsonProperty("_id")
    public void setId(String id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getv() {
        return v;
    }

    @JsonProperty("__v")
    public void setv(String v) {
        this.v = v;
    }

}
