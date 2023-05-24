package rest.dto;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GetTaskListItem {

    private int id;
    @JsonProperty("id_user")
    private int idUser;
  //  @JsonProperty("id_task")
    private int id_task;
    @JsonProperty("id_state")
    private int idState;
    @JsonProperty("cancelled_at")
    private Object cancelledAt;
    @JsonProperty("created_at")
    private Date createdAt;
    @JsonProperty("updated_at")
    private Date updatedAt;
    @JsonProperty("id_subgroup")
    private Object idSubgroup;
    private Task task;

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class TaskAssignee{
        private int id;
        private String avatar;
        private String email;
        private String firstName;
        private String secondName;
        @JsonProperty("laravel_through_key")
        private int laravelThroughKey;
        private String title;
        private String shortTitle;
        private Object userStatus;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class Assignee{
        private int id;
        private int role;
        @JsonProperty("id_task")
        private int idTask;
        @JsonProperty("id_state")
        private int idState;
        @JsonProperty("cancelled_at")
        private Object cancelledAt;
        @JsonProperty("created_at")
        private Date createdAt;
        @JsonProperty("updated_at")
        private Date updatedAt;
        @JsonProperty("id_user")
        private int idUser;
        @JsonProperty("assigned_by")
        private int assignedBy;
        @JsonProperty("assigned_date")
        private String assignedDate;
        @JsonProperty("cancelled_by")
        private Object cancelledBy;
        @JsonProperty("cancelled_date")
        private Object cancelledDate;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class User{
        private int id;
        private String firstName;
        private String full_name;
        private Object middleName;
        private String secondName;
        private Object nickname;
        private Object birthday;
        private String email;
        private String corporate_mail;
        private Object facebook;
        private Object googleplus;
        private Object linkedin;
        private Object twitter;
        private String phone;
        private Object address;
        private Object education;
        private int educform;
        private Object interests;
        private Object aboutUs;
        private Object aboutMy;
        private String avatar;
        private int role;
        private String reg_time;
        private Object skype;
        private int country;
        private Object city;
        private Object prev_job;
        private Object current_job;
        private int education_shift;
        private String title;
        private String shortTitle;
        private Object userStatus;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class State{
        private int id;
        private String name;
        private String description;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class UserTaskState{
        private int id;
        private int id_user;
        private int id_task;
        private int id_state;
        private Object cancelled_at;
        private Date created_at;
        private Date updated_at;
        private Object id_subgroup;
        private User user;
        private State state;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class TypeModel{
        private int id;
        private String title_ua;
        private String title_ru;
        private String title_en;
        private int order;
        private Object created_at;
        private Object updated_at;
        private String title;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class Organization{
        private int id;
        private String name;
        private Object email;
        private Object phone;
        private Object url;
        private double coefficient_offline;
        private double coefficient_online;
        private double coefficient_module_in_course;
        private Object facebook;
        private Object linkedin;
        private Object twitter;
        private String logo;
        private Object created_at;
        private Date updated_at;
        private int status;
        private Object description;
        private int services_count;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class Task{
        private int id;
        private String name;
        private String body;
        private String startTask;
        private String endTask;
        private Object deadline;
        private int id_state;
        private int created_by;
        private String created_date;
        private Object cancelled_by;
        private Object cancelled_date;
        private Object change_date;
        private int priority;
        private Object id_parent;
        private int type;
        private Object expected_time;
        private Object changed_by;
        private Date created_at;
        private Date updated_at;
        private int organization_id;
        private String typeName;
        private String organizationName;
        private TaskAssignee task_assignee;
        private ArrayList<Object> task_performers;
        private ArrayList<Assignee> assignee;
        private UserTaskState user_task_state;
        private TypeModel type_model;
        private Organization organization;
    }
}
