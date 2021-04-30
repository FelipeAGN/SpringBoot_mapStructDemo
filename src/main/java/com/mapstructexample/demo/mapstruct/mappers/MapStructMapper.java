package com.mapstructexample.demo.mapstruct.mappers;

import com.mapstructexample.demo.entities.Author;
import com.mapstructexample.demo.entities.Book;
import com.mapstructexample.demo.entities.User;
import com.mapstructexample.demo.mapstruct.dto.*;
import org.mapstruct.Mapper;

import java.util.List;

//By setting the componentModel attribute to spring, the MapStruct processor will produce a singleton Spring Bean mapper injectable wherever you need.
@Mapper(componentModel = "spring")
public interface MapStructMapper {

    BookSlimDto bookToBookSlimDto(Book book);

    BookDto bookToBookDto(Book book);

    AuthorDto authorToAuthorDto(Author author);

    AuthorAllDto authorToAuthorAllDto(Author author);

    List <AuthorAllDto> authorsToAuthorAllDtos(List<Author> authors);

    UserGetDto userToUserGetDto(User user);

    User userPostDtoToUser(UserPostDto userPostDto);
}
