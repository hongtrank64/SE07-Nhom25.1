package src.Entity;

import java.io.Serializable;
import java.util.Objects;

public class StudentSubject implements Serializable {

    public static class StudentSubjectId implements Serializable {
        private Student student;
        private Subject subject;

        public StudentSubjectId() {
        }

        public StudentSubjectId(Student student, Subject subject) {
            this.student = student;
            this.subject = subject;
        }

        public Student getStudent() {
            return student;
        }

        public void setStudent(Student student) {
            this.student = student;
        }

        public Subject getSubject() {
            return subject;
        }

        public void setSubject(Subject subject) {
            this.subject = subject;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            StudentSubjectId that = (StudentSubjectId) o;
            return Objects.equals(student, that.student) &&
                    Objects.equals(subject, that.subject);
        }

        @Override
        public int hashCode() {
            return Objects.hash(student, subject);
        }

        @Override
        public String toString() {
            return "StudentSubjectId{" +
                    "student=" + student +
                    ", subject=" + subject +
                    '}';
        }
    }

    private StudentSubjectId id;
    private boolean status;

    public StudentSubject() {
    }

    public StudentSubject(StudentSubjectId id, boolean status) {
        this.id = id;
        this.status = status;
    }

    public StudentSubjectId getId() {
        return id;
    }

    public void setId(StudentSubjectId id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StudentSubject{" +
                "id=" + id +
                ", status=" + status +
                '}';
    }
}


