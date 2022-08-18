<template>
    <div class="row">
        <div class="column column-11">{{ student.student_name }}</div>
        <div class="column column-11">{{ student.student_surname }}</div>
        <div class="column column-32">{{ student.student_address }}</div>
        <div class="column column-32">{{ student.student_email }}</div>
        <div class="column column-7">{{ student.student_course }}</div>
        <div class="column column-7 buttons">
            <button class="edit-buttons" @click="editClicked">Update</button>
            <button class="edit-buttons" @click="deleteClicked">Delete</button>
        </div>
    </div>
</template>

<script>

export default {
    props: [
        'student'
    ],
    methods: {
        editClicked: function() {
            this.$emit('edit', this.student.student_id)
        },
        deleteClicked: function() {
            this.$emit('delete', this.student.student_id)
        }
    }
}

</script>

<style>
.column {
    float: left;
    display: flex;
    height: 50px;
    flex-direction: column;
    justify-content: center;
}

.column-7 {
    width: 7%;
}

.column-11 {
    width: 11%;
}

.column-32 {
    width: 32%;
}

.row {
    padding: 15px;
    width: auto;
    background-color: lightgray;
    margin-bottom: 10px;
    border-radius: 5px;
}

/* Clear floats after the columns */
.row:after {
    content: "";
    display: table;
    clear: both;
}

.buttons {
    align-items: end;
}

.edit-buttons {
    width: 70px;
    margin-left: 5px;
    margin-right: 5px;
}
</style>