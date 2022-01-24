package Entity;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;
import java.io.Serializable;

public class TrainingScores implements Serializable{

    public static class TrainingScoresId implements Serializable {
        private Student student;

        public TrainingScoresId() {
        }

        public TrainingScoresId(Student student, String sem_year) {
            this.student = student;
        }

        public Student getStudent() {
            return student;
        }

        public void setStudent(Student student) {
            this.student = student;
        }

        @Override
        public String toString() {
            return "TrainingScoresID{" +
                    "student=" + student +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TrainingScoresId that = (TrainingScoresId) o;
            return Objects.equals(student, that.student);
        }

        @Override
        public int hashCode() {
            return Objects.hash(student);
        }
    }

    private TrainingScoresId id;

    @SerializedName("sem_year")
    private String sem_year;

    @SerializedName("scores")
    private Integer scores;

    public TrainingScores() {
    }

    public TrainingScores(TrainingScoresId id, String sem_year, Integer scores) {
        this.id = id;
        this.sem_year = sem_year;
        this.scores = scores;
    }

    public TrainingScoresId getId() {
        return id;
    }

    public void setId(TrainingScoresId id) {
        this.id = id;
    }

    public String getSem_year() {
        return sem_year;
    }

    public void setSem_year(String sem_year) {
        this.sem_year = sem_year;
    }

    public Integer getScores() {
        return scores;
    }

    public void setScores(Integer scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "TrainingScores{" +
                "id=" + id +
                ", sem_year='" + sem_year + '\'' +
                ", scores=" + scores +
                '}';
    }
}