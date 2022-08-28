<template>
    <div class="modal">
        <div class="header">
            <h2>Update Student</h2>
            <button class="edit-cancel" @click="cancel">✖</button>
        </div>
        <FormKit type="form" style="min-width: 500px; background-color: lightgrey; padding: 10px;">
            <FormKitSchema :schema="generatedSchema" />
        </FormKit>
    </div>
</template>

<script>
import { FormKitSchema } from '@formkit/vue'
import StudentFormSchema from "../config/StudentFormSchema.json"
export default {
    name: 'StudentEdit',
    components: {
        FormKitSchema
    },
    data() {
        return {
            StudentFormSchema,
            generatedSchema: ""
        }
    },
    props: [
        'student',
    ],
    methods: {
        cancel() {
            this.$emit('cancel')
        }
    },
    mounted() {
        this.generatedSchema = [
            {
                $formkit: "text",
                name: "name",
                label: "Student Name",
                help: "This is the name of the student",
                value: this.student.student_name,
                validation: "required"
            },
            {
                $formkit: "text",
                name: "surname",
                label: "Student Surname",
                help: "This is the surname of the student",
                value: this.student.student_surname,
                validation: "required"
            },
            {
                $formkit: "text",
                name: "adress",
                label: "Student Address",
                help: "The residential address of the student",
                value: this.student.student_address,
                validation: "required"
            },
            {
                $formkit: "text",
                name: "email",
                label: "Email",
                help: "This will be used for your account.",
                value: this.student.student_email,
                validation: "required|email"
            },
            {
                $formkit: "password",
                name: "password",
                label: "Password",
                help: "Student password",
                value: this.student.student_password,
                validation: "required|length:5,35"
            },
            {
                $formkit: "text",
                name: "course",
                label: "Student Course",
                help: "The course of the student",
                value: this.student.student_course,
                validation: "required"
            }
        ]
    }
}
</script>

<style>
.header {
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.modal {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);

    -webkit-box-shadow: -2px -1px 15px 7px rgba(0, 0, 0, 0.5);
    -moz-box-shadow: -3px -2px 30px 14px rgba(0, 0, 0, 0.425);
    box-shadow: -4px -3px 45px 21px rgba(0, 0, 0, 0.35);
}

.edit-cancel {
    background-color: red;
    padding: 8px 12px 8px 12px; /* top right bottom left */
    border-radius: 5px;
    cursor: pointer;
}
</style>