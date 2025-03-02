package com.project.questapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.questapp.entities.Post;
import com.project.questapp.entities.User;
import com.project.questapp.repos.PostRepository;
import com.project.questapp.requests.PostCreateRequest;
import com.project.questapp.requests.PostUpdateRequest;

@Service
public class PostService {

	private PostRepository postRepository; //postRepository bağlandık
	private UserService userService;       //userService bağlandık
	
	public PostService(PostRepository postRepository, UserService userService) {
		this.postRepository = postRepository;
		this.userService = userService;
	}

	public List<Post> getAllPosts(Optional<Long> userId) {
		if(userId.isPresent())  // eğer userId bana geldiyse
			return postRepository.findByUserId(userId.get());
		return postRepository.findAll(); // eğer gelmediyse tüm postları dön
	}

	public Post getOnePostById(Long postId) {
		return postRepository.findById(postId).orElse(null);
	
	}

	
	public Post createOnePost(PostCreateRequest newPostRequest) {
	User user =	userService.getOneUser(newPostRequest.getUserId()); //böyle bir user var mı ona bakıyoruz
		if(user == null)
			return null;
		Post toSave = new Post();
		toSave.setId(newPostRequest.getId());
		toSave.setText(newPostRequest.getText());
		toSave.setTitle(newPostRequest.getTitle());
		toSave.setUser(user);
	return postRepository.save(toSave);
	}

	public Post updateOnePostById(Long postId) {
		
		return null;
	}

	public void deleteOnePostById(Long postId) {
		postRepository.deleteById(postId);
	}

	public Post updateOnePostById(Long postId, PostUpdateRequest updatePost) {
		Optional<Post> post = postRepository.findById(postId);
		if(post.isPresent()) {
			Post toUpdate = post.get();
			toUpdate.setText(updatePost.getText());
			toUpdate.setTitle(updatePost.getTitle());
			postRepository.save(toUpdate);
			return toUpdate;
		}
		return null;
	}
}
