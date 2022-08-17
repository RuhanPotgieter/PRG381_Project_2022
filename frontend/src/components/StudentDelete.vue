<template>
    <div class="modal">
        <h1>Are you sure you want to delete</h1>
        <h3>{{ student.student_name }}?</h3>
        <button>Delete</button>
        <button class="cancel" @click="cancel">Cancel</button>
    </div>
</template>

<script>

export default {
    props: [
        'student'
    ],
    methods: {
        cancel() {
            this.$emit('cancel')
        }
    }
}

</script>

<style>
.modal {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    background-color: lightgrey;
    padding: 30px;
    border-radius: 15px;

    -webkit-box-shadow: -2px -1px 15px 7px rgba(0, 0, 0, 0.5);
    -moz-box-shadow: -3px -2px 30px 14px rgba(0, 0, 0, 0.425);
    box-shadow: -4px -3px 45px 21px rgba(0, 0, 0, 0.35);
}

.cancel {
    position: absolute;
    right: 8%;
}
</style>