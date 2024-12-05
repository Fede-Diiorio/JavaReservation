package com.coderhouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.dtos.UserReqDTO;
import com.coderhouse.dtos.UserResDTO;
import com.coderhouse.interfaces.DAOInterface;
import com.coderhouse.mappers.UserMapper;
import com.coderhouse.models.Role;
import com.coderhouse.models.User;
import com.coderhouse.repositories.UserRepository;

@Service
public class UserService implements DAOInterface<UserReqDTO, UserResDTO> {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private RoleService roleService;

	@Override
	public List<UserResDTO> getAll() {
		List<User> users = userRepository.findAll();
		return users.stream().map(userMapper::toDTO).toList();
	}

	@Override
	public UserResDTO getById(Long id) {
		User user = getUserById(id);
		return userMapper.toDTO(user);
	}

	@Override
	public UserResDTO save(UserReqDTO object) {
		User user = userMapper.toUser(object);
		validateMandatoryFields(user);
		userRepository.save(user);
		return userMapper.toDTO(user);
	}

	@Override
	public UserResDTO update(Long id, UserReqDTO object) throws Exception {
		User findedUser = getUserById(id);
		User user = userMapper.toUser(object);

		if (user.getEmail() != null && !user.getEmail().isEmpty()) {
			findedUser.setEmail(user.getEmail());
		}

		if (user.getName() != null && !user.getName().isEmpty()) {
			findedUser.setName(user.getName());
		}

		if (user.getRole() != null) {
			Role role = roleService.getRoleById(object.getRole());

			if (role != null) {
				findedUser.setRole(role);
			}
		}

		User updatedUser = userRepository.save(findedUser);

		return userMapper.toDTO(updatedUser);
	}

	@Override
	public void delete(Long id) {
		if (!userRepository.existsById(id)) {
			throw new IllegalArgumentException("Usuario no encontrado.");

		}
		userRepository.deleteById(id);

	}

	public User getUserById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("El usuario no existe"));
	}

	private void validateMandatoryFields(User user) {
		if (user.getEmail() == null || user.getEmail().isEmpty()) {
			throw new IllegalArgumentException("El email del usuario es olbigatorio.");
		}
		if (user.getName() == null || user.getName().isEmpty()) {
			throw new IllegalArgumentException("El nombre del usuario es olbigatorio.");
		}
		if (user.getRole() == null) {
			throw new IllegalArgumentException("El rol del usuario es olbigatorio.");
		}
	}
}
