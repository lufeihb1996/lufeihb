<template>
  <div>
    <h1>Posts</h1>
    <form @submit.prevent="submit">
      <input v-model="form.title" placeholder="Title" required />
      <textarea v-model="form.content" placeholder="Content" required />
      <button type="submit">Add Post</button>
    </form>
    <ul>
      <li v-for="post in posts" :key="post.id">
        <div v-if="editing === post.id">
          <input v-model="editForm.title" />
          <textarea v-model="editForm.content" />
          <button @click="update(post.id)">Save</button>
          <button @click="cancel()">Cancel</button>
        </div>
        <div v-else>
          <h3>{{ post.title }}</h3>
          <p>{{ post.content }}</p>
          <button @click="startEdit(post)">Edit</button>
          <button @click="remove(post.id)">Delete</button>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      posts: [],
      form: { title: '', content: '' },
      editForm: { title: '', content: '' },
      editing: null
    }
  },
  mounted() {
    this.load()
  },
  methods: {
    async load() {
      const res = await axios.get('http://localhost:8080/posts')
      this.posts = res.data
    },
    async submit() {
      const res = await axios.post('http://localhost:8080/posts', this.form)
      this.posts.push(res.data)
      this.form.title = ''
      this.form.content = ''
    },
    startEdit(post) {
      this.editing = post.id
      this.editForm.title = post.title
      this.editForm.content = post.content
    },
    cancel() {
      this.editing = null
    },
    async update(id) {
      const res = await axios.put(`http://localhost:8080/posts/${id}`, this.editForm)
      const idx = this.posts.findIndex(p => p.id === id)
      if (idx !== -1) this.posts[idx] = res.data
      this.editing = null
    },
    async remove(id) {
      await axios.delete(`http://localhost:8080/posts/${id}`)
      this.posts = this.posts.filter(p => p.id !== id)
    }
  }
}
</script>
