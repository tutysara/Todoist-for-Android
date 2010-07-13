/*    
	This file is part of Todoist for Android�.

    Todoist for Android� is free software: you can redistribute it and/or 
    modify it under the terms of the GNU General Public License as published 
    by the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Todoist for Android� is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Todoist for Android�.  If not, see <http://www.gnu.org/licenses/>.
    
    This file incorporates work covered by the following copyright and  
 	permission notice:
 	
 	Copyright [2010] pskink <pskink@gmail.com>
 	Copyright [2010] ys1382 <ys1382@gmail.com>
 	Copyright [2010] JonTheNiceGuy <JonTheNiceGuy@gmail.com>

   	Licensed under the Apache License, Version 2.0 (the "License");
   	you may not use this file except in compliance with the License.
   	You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   	Unless required by applicable law or agreed to in writing, software
   	distributed under the License is distributed on an "AS IS" BASIS,
   	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   	See the License for the specific language governing permissions and
   	limitations under the License.
*/

package com.drewdahl.android.todoist.users;

import org.json.JSONException;
import org.json.JSONObject;

import com.android.applications.todoist.Constants;
import com.drewdahl.android.todoist.apihandlers.TodoistApiHandler;
import com.drewdahl.android.todoist.projects.Project;

/**
 * 
 * @author Andrew Dahl
 *
 * TODO Add a save method to this class that saves it in the cache and
 * updates the server.  We can then update the caching times by using this
 * class as a wrapper to everything else that manages our data stores.
 */
public class User {
	/**
	 * This class should always be created from the API Handler as it should 
	 * associate the user with an actual todoist account.  Without that what
	 * use is there for this thing?
	 */
	
	/**
	 * @param JSONObject obj Just so we never get confused.
	 */
	public User(JSONObject obj) throws JSONException
	{
		email = obj.getString(Constants.JSON_EMAIL);
		full_name = obj.getString(Constants.JSON_FULLNAME);
		id = obj.getInt(Constants.JSON_ID);
		api_token = obj.getString(Constants.JSON_APITOKEN);
		start_page = obj.getString(Constants.JSON_STARTPAGE);
		timezone = obj.getString(Constants.JSON_TIMEZONE);
		tz_offset = obj.getJSONObject(Constants.JSON_TZOFFSET);
		time_format = obj.getInt(Constants.JSON_TIMEFORMAT);
		date_format = obj.getInt(Constants.JSON_DATEFORMAT);
		sort_order = obj.getInt(Constants.JSON_SORTORDER);
		twitter = obj.getString(Constants.JSON_TWITTER);
		jabber = obj.getString(Constants.JSON_JABBER);
		msn = obj.getString(Constants.JSON_MSN);
		mobile_number = obj.getString(Constants.JSON_MOBILENUMBER);
		mobile_host = obj.getString(Constants.JSON_MOBILEHOST);
		token = obj.getString(Constants.JSON_TOKEN);
	}
	
	public Project[] GetProjects()
	{
		return TodoistApiHandler.getInstance(token).getProjects();
	}
	
	/**
	 * Getters and Setters ...
	 */
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getFullName()
	{
		return full_name;
	}
	
	public void setFullName(String full_name)
	{
		this.full_name = full_name;
	}
	
	public Integer getId()
	{
		return id;
	}
	
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public String getApiToken()
	{
		return api_token;
	}
	
	public void setApiToken(String api_token)
	{
		this.api_token = api_token;
	}
	
	public String getStartPage()
	{
		return start_page;
	}
	
	public void setStartPage(String start_page)
	{
		this.start_page = start_page;
	}
	
	public String getTimezone()
	{
		return timezone;
	}
	
	public void setTimezone(String timezone)
	{
		this.timezone = timezone;
	}
	
	public JSONObject getTzOffset()
	{
		return tz_offset;
	}
	
	public void setTzOffset(JSONObject tz_offset)
	{
		this.tz_offset = tz_offset;
	}
	
	public Integer getTimeFormat()
	{
		return time_format;
	}
	
	public void setTimeFormat(Integer time_format)
	{
		this.time_format = time_format;
	}
	
	public Integer getDateFormat()
	{
		return date_format;
	}
	
	public void setDateFormat(Integer date_format)
	{
		this.date_format = date_format;
	}
	
	public Integer getSortOrder()
	{
		return sort_order;
	}
	
	public void setSortOrder(Integer sort_order)
	{
		this.sort_order = sort_order;
	}
	
	public String getTwitter()
	{
		return twitter;
	}
	
	public void setTwitter(String twitter)
	{
		this.twitter = twitter;
	}
	
	public String getJabber()
	{
		return jabber;
	}
	
	public void setJabber(String jabber)
	{
		this.jabber = jabber;
	}
	
	public String getMsn()
	{
		return msn;
	}
	
	public void setMsn(String msn)
	{
		this.msn = msn;
	}
	
	public String getMobileNumber()
	{
		return mobile_number;
	}
	
	public void setMobileNumber(String mobile_number)
	{
		this.mobile_number = mobile_number;
	}
	
	public String getMobileHost()
	{
		return mobile_host;
	}
	
	public void setMobileHost(String mobile_host)
	{
		this.mobile_host = mobile_host;
	}
	
	public String getToken()
	{
		return token;
	}
	
	private String email;		  // User's e-mail address	someGuy@someDomain.com
	private String full_name;	  // User's full name 		Joe Anderson
	private int id;			  // User's ID				156841
	private String api_token;	  // User's API Token		d18a76ab310947100kc60fe9b3cdc466515bb3a1 -- 40-digit hex
	private String start_page;	  // User's start_page		_info_page
	private String timezone;	  // User's Local Timezone	US/Central
	private JSONObject tz_offset;	  // User's Timezone Offset	["-5:00", -5, 0, 1] -- [GMT_STRING, HOURS, MINUTES, IS_DAYLIGHT_SAVINGS_TIME]
	private int time_format;	  // User's time format		0 = 13:00 else 1pm
	private int date_format;	  // User's date format		0 = DD-MM-YYYY else MM-DD-YYYY
	private int sort_order;	  // User's sort order		0 = Oldest dates first else Oldest dates last
	private String twitter;		  // User's twitter account	
	private String jabber;		  // User's jabber account	joe@doe.com
	private String msn;			  // User's msn account		amix_bin@msn.com
	private String mobile_number; // User's mobile number	
	private String mobile_host;	  // User's mobile host
	private String token;         // The login session token from the API.
}
