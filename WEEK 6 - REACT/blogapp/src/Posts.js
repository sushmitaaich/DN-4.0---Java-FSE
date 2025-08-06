import React from 'react';
import Post from './Post';

class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      error: null
    };
  }

  // STEP 4: Load Posts using Fetch
  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => {
        if (!response.ok) {
          throw new Error("Network response was not OK");
        }
        return response.json();
      })
      .then(data => {
        const postObjects = data.map(item => new Post(item.id, item.title, item.body));
        this.setState({ posts: postObjects });
      })
      .catch(error => {
        this.setState({ error });
      });
  }

  // STEP 5: Call loadPosts in componentDidMount
  componentDidMount() {
    this.loadPosts();
  }

  // STEP 6: Catch any errors
  componentDidCatch(error, info) {
    alert(`Error occurred: ${error.toString()}`);
    console.error("Error details:", info);
  }

  // STEP 7: Render the Posts
  render() {
    if (this.state.error) {
      return <p>Error loading posts: {this.state.error.message}</p>;
    }

    return (
      <div style={{ padding: '20px' }}>
        <h2>Blog Posts</h2>
        {this.state.posts.map(post => (
          <div key={post.id} style={{ borderBottom: '1px solid #ccc', marginBottom: '15px' }}>
            <h3>{post.title}</h3>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;
