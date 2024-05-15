package com.recipe.post.dto;

public class PostDto {

    private int RecipeID;
    private String RCategory;
    private String Title;
    private String Description;
    private String ImagePath;
    private String ID;
    private int LikeCount;
    private int CommentCount;

    public PostDto(){

    }

    public PostDto(int recipeID, String RCategory, String title, String description, String imagePath, String ID, int likeCount, int commentCount) {
        RecipeID = recipeID;
        this.RCategory = RCategory;
        Title = title;
        Description = description;
        ImagePath = imagePath;
        this.ID = ID;
        LikeCount = likeCount;
        CommentCount = commentCount;
    }

    public int getRecipeID() {
        return RecipeID;
    }

    public void setRecipeID(int recipeID) {
        RecipeID = recipeID;
    }

    public String getRCategory() {
        return RCategory;
    }

    public void setRCategory(String RCategory) {
        this.RCategory = RCategory;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getLikeCount() {
        return LikeCount;
    }

    public void setLikeCount(int likeCount) {
        LikeCount = likeCount;
    }

    public int getCommentCount() {
        return CommentCount;
    }

    public void setCommentCount(int commentCount) {
        CommentCount = commentCount;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "RecipeID=" + RecipeID +
                ", RCategory='" + RCategory + '\'' +
                ", Title='" + Title + '\'' +
                ", Description='" + Description + '\'' +
                ", ImagePath='" + ImagePath + '\'' +
                ", ID='" + ID + '\'' +
                ", LikeCount=" + LikeCount +
                ", CommentCount=" + CommentCount +
                '}';
    }
}
