<template>
    <div>
        <div style="padding:25px;">
            <h1 style="text-align:center">Student Admin Portal</h1>
            <button class="add">Add Student</button>
            <div class="heading-row">
                <div class="heading-column heading-column-18">Name</div>
                <div class="heading-column heading-column-32">Address</div>
                <div class="heading-column heading-column-32">Email</div>
                <div class="heading-column heading-column-9">Course</div>
                <div class="heading-column heading-column-9 edit">Edit / Delete</div>
            </div>
            <StudentListItem v-for="student in Students" :key="student.student_id" :student="student" @edit="editShow" @delete="deleteShow" />
            
        </div>
        <StudentEdit v-if="bShowEditModal" :student="student" @cancel="editCancel" />
        <StudentDelete v-if="bShowDeleteModal" :student="student" @cancel="deleteCancel" />
    </div>
</template>

<script>
import Students from '../config/Students.json'
import StudentListItem from '@/components/StudentListItem.vue'
import StudentEdit from "@/components/StudentEdit.vue"
import StudentDelete from "@/components/StudentDelete.vue"

export default {
    data() {
        return {
            Students,
            student: null,
            bShowEditModal: false,
            bShowDeleteModal: false,
        }
    },
    components: {
        StudentListItem,
        StudentEdit,
        StudentDelete
    },
    methods: {
        editShow(id) {
            this.student = this.Students[id]
            this.bShowEditModal = true
            this.bShowDeleteModal = false
        },
        deleteShow(id) {
            this.student = this.Students[id]
            this.bShowDeleteModal = true
            this.bShowEditModal = false
        },
        editCancel() {
            this.bShowEditModal = false
        },
        deleteCancel() {
            this.bShowDeleteModal = false
        }
    }
}

</script>

<style>
.heading-row {
    padding: 15px;
    width: auto;
    background-color: grey;
    margin-bottom: 15px;
    border-radius: 5px;
    text-transform: uppercase;
}

/* Clear floats after the columns */
.heading-row:after {
    content: "";
    display: table;
    clear: both;
}

.heading-column {
    float: left;
    width: 25%;
    font-weight: bolder;
    width: 18%;
    display: flex;
    height: 50px;
    flex-direction: column;
    justify-content: center;
}

.heading-column-9 {
    width: 9%;
}

.heading-column-18 {
    width: 18%;
}

.heading-column-32 {
    width: 32%;
}

.edit {
    text-align: right;
}

.add {
    position: absolute;
    top: 15px;
    right: 15px;
    background-color: lightgreen;
    padding: 20px;
    text-align: center;
    border-radius: 5px;
    font-size: larger;
    font-weight: bolder;
    text-transform: uppercase;
}
</style>