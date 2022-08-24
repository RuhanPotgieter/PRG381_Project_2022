<template>
    <div class="modal">
        <div class="header">
            <h2>Add Student</h2>
            <button class="edit-cancel" @click="cancel">✖</button>
        </div>
        <FormKit type="form" style="min-width: 500px; background-color: lightgrey; padding: 10px;">
            <FormKitSchema :schema="StudentFormSchema" />
        </FormKit>
    </div>
</template>

<script>
import { FormKitSchema } from '@formkit/vue'
import StudentFormSchema from "../config/StudentFormSchema.json"
export default {
    name: 'StudentAdd',
    components: {
        FormKitSchema
    },
    data() {
        return {
            StudentFormSchema
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