<template>
    <div>
        <Navbar />
        <div style="padding:25px; background-color: honeydew;">
            <div class="header">
                <h1 style="text-align:center">Student Admin Portal</h1>
                <button class="add" @click="addShow">Add Student</button>
            </div>
            <div class="heading-row">
                <div class="heading-column heading-column-11">Name</div>
                <div class="heading-column heading-column-11">Surname</div>
                <div class="heading-column heading-column-32">Address</div>
                <div class="heading-column heading-column-32">Email</div>
                <div class="heading-column heading-column-7">Course</div>
                <div class="heading-column heading-column-7 edit">Update / Delete</div>
            </div>
            <StudentListItem v-for="student in Students" :key="student.student_id" :student="student" @edit="editShow"
                @delete="deleteShow" />

        </div>
        <StudentAdd v-if="bShowAddModal" @cancel="addCancel" />
        <StudentEdit v-if="bShowEditModal" :student="student" @cancel="editCancel" />
        <StudentDelete v-if="bShowDeleteModal" :student="student" @cancel="deleteCancel" />
    </div>
</template>

<script>
import Students from '../config/Students.json'
import StudentListItem from '@/components/StudentListItem.vue'
import StudentAdd from "@/components/StudentAdd.vue"
import StudentEdit from "@/components/StudentEdit.vue"
import StudentDelete from "@/components/StudentDelete.vue"
import Navbar from "../components/Navbar.vue"

export default {
    data() {
        return {
            Students,
            student: null,
            bShowAddModal: false,
            bShowEditModal: false,
            bShowDeleteModal: false,
        }
    },
    components: {
        StudentListItem,
        StudentAdd,
        StudentEdit,
        StudentDelete,
        Navbar,
    },
    methods: {
        addShow() {
            this.bShowAddModal = true
            this.bShowEditModal = false
            this.bShowDeleteModal = false
        },
        editShow(id) {
            this.student = this.Students[id]
            this.bShowEditModal = true
            this.bShowAddModal = false
            this.bShowDeleteModal = false
        },
        deleteShow(id) {
            this.student = this.Students[id]
            this.bShowDeleteModal = true
            this.bShowAddModal = false
            this.bShowEditModal = false
        },
        addCancel() {
            this.bShowAddModal = false
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
.header {
    display: flex;
    justify-content: space-between;
    align-items: center;
}

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

.heading-column-7 {
    width: 7%;
}

.heading-column-11 {
    width: 11%;
}

.heading-column-32 {
    width: 32%;
}

.edit {
    text-align: right;
}

.add {
    background-color: lightgreen;
    padding: 20px;
    text-align: center;
    border-radius: 5px;
    font-size: larger;
    font-weight: bolder;
    text-transform: uppercase;
    cursor: pointer;
}
</style>