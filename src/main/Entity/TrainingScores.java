package Entity;

import java.util.Objects;
import java.io.Serializable;

public class TrainingScores implements Serializable{

    public static class TrainingScoresId implements Serializable {
        private Student student;
        private String sem_year;

        public TrainingScoresId() {
        }

        public TrainingScoresId(Student student, String sem_year) {
            this.student = student;
            this.sem_year = sem_year;
        }

        public Student getStudent() {
            return student;
        }

        public void setStudent(Student student) {
            this.student = student;
        }

        public String getSem_year() {
            return sem_year;
        }

        public void setSem_year(String sem_year) {
            this.sem_year = sem_year;
        }

        @Override
        public String toString() {
            return "TrainingScoresID{" +
                    "student=" + student +
                    ", sem_year='" + sem_year + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TrainingScoresId that = (TrainingScoresId) o;
            return Objects.equals(student, that.student) &&
                    Objects.equals(sem_year, that.sem_year);
        }

        @Override
        public int hashCode() {
            return Objects.hash(student, sem_year);
        }
    }

    private TrainingScoresId id;
    private Integer scores;

    public TrainingScores() {
    }

    public TrainingScores(TrainingScoresId id, Integer scores) {
        this.id = id;
        this.scores = scores;
    }

    public TrainingScoresId getId() {
        return id;
    }

    public void setId(TrainingScoresId id) {
        this.id = id;
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
                ", scores=" + scores +
                '}';
    }
}


