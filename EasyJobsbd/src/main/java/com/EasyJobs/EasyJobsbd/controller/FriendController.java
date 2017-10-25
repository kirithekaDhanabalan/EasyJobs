package com.EasyJobs.EasyJobsbd.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.EasyJobs.EasyJobsbd.dao.FriendDAO;
import com.EasyJobs.EasyJobsbd.model.Forum;
import com.EasyJobs.EasyJobsbd.model.Friend;
import com.EasyJobs.EasyJobsbd.model.FriendRequest;
import com.EasyJobs.EasyJobsbd.model.Users;

@RestController
public class FriendController 
{
	 //------------------- Suggested User --------------------------------------------------------
	@Autowired
	 FriendDAO friendService;
	
	@RequestMapping(value = "/suggesteduser", method = RequestMethod.GET)
    public ResponseEntity<List<Users>> listSuggestedUsers(HttpSession session) 
    {
        List<Users> suggesteduser = friendService.suggestedUsers(session.getAttribute("username").toString());
        System.out.println(suggesteduser);
        if(suggesteduser.isEmpty())
        {
            return new ResponseEntity<List<Users>>(HttpStatus.NO_CONTENT);
        }
        else
        {
        	return new ResponseEntity<List<Users>>(suggesteduser, HttpStatus.OK);
        }
    }
    
	//-------------------List Of Friends--------------------------------------------------------
    @RequestMapping(value = "/friends/{username}", method = RequestMethod.GET)
    public ResponseEntity<List<Friend>> listOfFriends(@PathVariable("username") String username,HttpSession session) 
    {
        List<Friend> allfriends = friendService.listOfFriends(username);
        if(allfriends.isEmpty())
        {
            return new ResponseEntity<List<Friend>>(HttpStatus.NO_CONTENT);
        }
        else
        {
        	return new ResponseEntity<List<Friend>>(allfriends, HttpStatus.OK);
        }
    }
   
  //-------------------sending request--------------------------------------------------------
    @RequestMapping(value="/friendrequest/{receiver}",method=RequestMethod.GET)
    public ResponseEntity<String> sendRequest(@PathVariable("receiver") String receiver,HttpSession session)
    {
    	if(friendService.sendFriendRequest(receiver, session.getAttribute("username").toString())) {
    		
			return new ResponseEntity<String>(HttpStatus.OK);
		} else {
			// TODO: handle exception
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
    }
    
  //-------------------List Of FriendRequest --------------------------------------------------------
    @RequestMapping(value="/friendrequest",method=RequestMethod.GET)
    public ResponseEntity<List<FriendRequest>> pendingRequest(HttpSession session) 
    {
        List<FriendRequest> allfriends = friendService.friendRequestPending(session.getAttribute("username").toString());
        if(allfriends.isEmpty())
        {
            return new ResponseEntity<List<FriendRequest>>(HttpStatus.NO_CONTENT);
        }
        else
        {
        	return new ResponseEntity<List<FriendRequest>>(allfriends, HttpStatus.OK);
        }
    }
    
    
    @RequestMapping(value="/friendrequestaccept/{id}",method=RequestMethod.GET)
    public ResponseEntity<String> addFriend(@PathVariable("id") int id,HttpSession session) 
    {
        FriendRequest friendRequest=friendService.singleRequest(id);
        if(friendService.addAsFriend(friendRequest.getReceiverName(), friendRequest.getSenderName()))
        {
            return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
        }
        else
        {
        	return new ResponseEntity<String>(HttpStatus.OK);
        }
    }
    
    @GetMapping(value = "/friendrequest/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FriendRequest> getFriendRequest(@PathVariable("id") int id) {
    	FriendRequest friendrequest = friendService.singleRequest(id);
		if (friendrequest == null) {
			return new ResponseEntity<FriendRequest>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<FriendRequest>(friendrequest, HttpStatus.OK);
		}
	}
  
    
    @RequestMapping(value = "/friendrequest/{id}", method = RequestMethod.PUT)
    public ResponseEntity<FriendRequest> updatePendingRequest(@PathVariable("id") int id,HttpSession session)
    {
    	
    	FriendRequest friendrequest = friendService.singleRequest(id);
        if (friendrequest == null) 
        {
            return new ResponseEntity<FriendRequest>(HttpStatus.NOT_FOUND);
        }
        else
        {
        	
        	friendService.updatePendingRequest(id);
        	return new ResponseEntity<FriendRequest>(HttpStatus.OK);
        }
    }


}
