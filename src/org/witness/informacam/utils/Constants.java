package org.witness.informacam.utils;

import info.guardianproject.odkparser.Constants.Form;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.witness.informacam.R;
import org.witness.informacam.app.editors.filters.CrowdPixelizeObscure;
import org.witness.informacam.app.editors.filters.Filter;
import org.witness.informacam.app.editors.filters.InformaTagger;
import org.witness.informacam.app.editors.filters.PixelizeObscure;
import org.witness.informacam.app.editors.filters.SolidObscure;

import android.media.ExifInterface;
import android.os.Environment;
import android.preference.ListPreference;
import android.preference.Preference;
import android.provider.BaseColumns;
import android.util.Log;

public class Constants {
	public final static class Time {
		public final static String LOG = "**************** InformaCam: TIME ****************";
		public static final class Keys {

			public static final String RELATIVE_TIME = "mediaRelativeTimestamp";
			
		}
	}
	
	
	public final static class App {
		public static final String LOG = "**************** InformaCam:UI Thread ****************";
		public static final class Services {
			public static final int FROM_DATABASE_SERVICE = 1075;
		}
		
		public static final class InformaService {
			public static final class Keys {

				public static final String FROM_NOTIFICATION = "fromNotification";
				
			}
			
			public static final class Notifications {
				public static final int INIT = 1;
				
			}
		}
		
		public final static class Eula {
			
		}
		
		public final static class Wizard {
			public final static int FROM_BASE_IMAGE_CAPTURE = 884;
			public final static int FROM_ADDRESSBOOK_CHOOSER = 885;
		}
		
		public final static class LogIn {
			
		}
		
		public final static class Main {
			public final static int FROM_MEDIA_CAPTURE = 774;
			public final static int FROM_EDITOR = 775;
			public final static int FROM_MEDIA_MANAGER = 776;
			public static final String SERVICE_STARTED = "serviceStarted";
			public static final String MEDIA_CAPTURE_URI_SAVED_STATE = "mediaCaptureURI_SavedState";
			public static final String MEDIA_CAPTURE_FILE_SAVED_STATE = "mediaCaptureFile_SavedState";
			public static final int GPS_WAIT_MAX = 16;
			public static final String FORCE_CLOSE_REPORTED = "forceCloseReported";
		}
		
		public final static class MediaManager {
			public final static int WITH_MEDIA_TO_OPEN = 574;
		}
		
		public final static class AddressBook {
			public final static int FROM_CONTACT_CHOOSER = 674;
			public final static int FROM_ASC_IMPORT = 675;
			public final static int FROM_USER_CHOICE = 676;
		}
		
		public final static class VideoEditor {
			public final static int FROM_ANNOTATION_ACTIVITY = App.ImageEditor.FROM_ANNOTATION_ACTIVITY;
			public final static int FROM_DESTINATION_CHOOSER = App.ImageEditor.FROM_DESTINATION_CHOOSER;
			public static final int PACKAGE_GENERATED = App.ImageEditor.PACKAGE_GENERATED;
			public final static int SAVED_STATE = App.ImageEditor.SAVED_STATE;
			
			public final static int FACE_TIME_BUFFER = 2000;
		    public final static int HUMAN_OFFSET_BUFFER = 50;
			public final static float MIN_MOVE = 10;
			
			public static final String OBSCURE_MODE_REDACT = "black";
			public static final String OBSCURE_MODE_PIXELATE = "pixel";
			public static final String OBSCURE_MODE_IDENTIFY = "identify";
			
			public final static class Mode {
				public static final int NONE = 0;
				public static final int DRAG = 1;
			}
			
			public final static String TAG = "app.editors.video.VideoEditor";
			
			public final static class Preferences {
				public final static int DEFAULT_OUT_WIDTH = 480;
				public static final int DEFAULT_OUT_HEIGHT = 320;
				public final static int DEFAULT_OUT_FPS = 15;
				public final static int DEFAULT_OUT_RATE = 300;
				public final static String DEFAULT_OUT_FORMAT = "mp4";
				public final static String DEFAULT_OUT_VCODEC = "libx264";
				public final static String DEFAULT_OUT_ACODEC = "copy";
				public static final String FRAME_RATE = "pref_out_fps";
				public static final String BIT_RATE = "pref_out_rate";
				public static final String FORMAT = "pref_out_format";
				public static final String ACODEC = "pref_out_acodec";
				public static final String VCODEC = "pref_out_vcodec";
				public static final String WIDTH = "pref_out_vwidth";
				public static final String HEIGHT= "pref_out_vheight";
				public static final String DIMENSIONS = "pref_out_vdimensions";
				
				public static final class Dimensions {
					public static final int ORIGINAL = 500;
					public static final int HD = 501;
					public static final int SD_H = 502;
					public static final int SD_L = 503;
				}
				
				
			}
			
			public final static class Keys {
				public final static String PROPERTIES = App.ImageEditor.Keys.PROPERTIES;
				public final static String CHOOSE_TRUSTED_DESTINATION = App.ImageEditor.Keys.CHOOSE_TRUSTED_DESTINATION;
				public final static String FINISH_ON = App.ImageEditor.Keys.FINISH_ON;
			}
			
			public final static List<Filter> INFORMA_CAM_PLUGINS;
			static {
				List<Filter> InformaCamPlugins = new ArrayList<Filter>();
				
				
				InformaCamPlugins.add(new Filter("Pixelate", R.drawable.ic_context_pixelate, null, OBSCURE_MODE_PIXELATE));
				InformaCamPlugins.add(new Filter("Redact", R.drawable.ic_context_fill, null, OBSCURE_MODE_REDACT));
				
				INFORMA_CAM_PLUGINS = Collections.unmodifiableList(InformaCamPlugins);
			}
			
			public final static class Actions {
				public final static int REVIEW_MEDIA = 0;
				public final static int SAVE_MENU_ITEM = 1;
				
				public final static int PLAY = 1;
				public final static int STOP = 2;
				public final static int PROCESS = 3;
				
			}
		}
		
		public final static class ImageEditor {
			public final static int FROM_ANNOTATION_ACTIVITY = 574;
			public final static int FROM_DESTINATION_CHOOSER = 575;
			public static final int PACKAGE_GENERATED = 573;
			public static final int SAVED_STATE = 572;
			
			public final static String TAG = "app.editors.image.ImageEditor";
			
			public final static class Mode {
				public static final int NONE = 0;
				public static final int DRAG = 1;
				public static final int ZOOM = 2;
				public static final int TAP = 3;
			}
			
			public static final int QUALITY = 100;
			public static final String GALLERY_NAME = System.currentTimeMillis() + "_InformaCamImage.jpg";
			
			// Maximum zoom scale
			public static final float MAX_SCALE = 10f;
			public final static float CORNER_SIZE = 26;
			
			// Constant for autodetection dialog
			public static final int DIALOG_DO_AUTODETECTION = 0;
			public final static String MIME_TYPE_JPEG = Media.Type.MIME_TYPE_JPEG;
			
			
			public final static class Color {
				public final static int DRAW_COLOR = 0x00000000;
				public final static int DETECTED_COLOR = 0x00000000;
				public final static int OBSCURED_COLOR = 0x00000000;
			}
			
			public final static class Actions {
				public final static int REVIEW_MEDIA = 0;
				public final static int SAVE_MENU_ITEM = 1;
				public final static int SHARE_MENU_ITEM = 2;
				public final static int NEW_REGION_MENU_ITEM = 3;
			}
			
			public final static List<Filter> INFORMA_CAM_PLUGINS;
			static {
				List<Filter> InformaCamPlugins = new ArrayList<Filter>();
				
				InformaCamPlugins.add(new Filter("Pixelate", R.drawable.ic_context_pixelate, PixelizeObscure.class, "p"));
				InformaCamPlugins.add(new Filter("Redact", R.drawable.ic_context_fill, SolidObscure.class, "s"));
				InformaCamPlugins.add(new Filter("CrowdPixel", R.drawable.ic_context_pixelate, CrowdPixelizeObscure.class, "i"));				
				
				INFORMA_CAM_PLUGINS = Collections.unmodifiableList(InformaCamPlugins);
			}
			
			public final static class Filters {
				public final static String PIXELIZE = "p";
				public final static String INFORMA_TAGGER = "t";
				public final static String CROWD_PIXELIZE = "i";
				public final static String SOLID = "s";
				public final static String VIDEO_PIXELIZE = "pixel";
			}
			
			public final static class Keys {
				public final static String PROPERTIES = "mProps";
				public final static String CHOOSE_TRUSTED_DESTINATION = "chooseTrustedDestination";
				public final static String FINISH_ON = "finishOn";
				
			}
		}

		public static final class MessageCenter {
			public final static class Actions {
				public static final int VIEW_THREAD = 23;
			}
			
			public static final class Keys {
				public final static String THREAD_BASE = Media.Manifest.Keys.J3MBASE;
				public static final String FROM_URL = Media.Manifest.Keys.URL;
				public final static String CERT_ID = Media.Manifest.Keys.CERTS;
				public static final String ALIAS = Media.Manifest.Keys.ALIAS;
				
			}
		}

		public static class Preferences {
			public final static String LOG = "**************** InformaCam:Prefs ****************";
		}
	}
	
	public final static class Mods {
		public final static class Selections {
			public final static String SELECT_ONE = "select_one";
			public final static String SELECT_MULTI = "select_multi";
		}
	}
	
	public final static class AddressBook {
		public final static class Projections {
			public final static String[] LIST_DISPLAY = TrustedDestination.Projections.FOR_ADDRESSBOOK_DISPLAY;
		}
		
		public final static class Actions {
			public final static int VIEW_DETAILS = 0;
		    public final static int REFRESH_KEY = 1;
		    public final static int DELETE_CONTACT = 2;
		}
		
		public final static class Keys {
			public final static String CONTACT_PHOTO = "contactPhoto";
			public final static String CONTACT_NAME = "contactName";
			public final static String CONTACT_EMAIL = "contactEmail";
			public final static String CONTACT_ID = "contactID";
			public static final String CONTACT_SELECTED = "contactSelectedAsTrustedDestination";
		}
	}
	
	public final static class MediaManager {
		public final static class Actions {
			public final static int RENAME_MEDIA = 0;
			public final static int EXPORT_MEDIA = 1;
			public final static int DELETE_MEDIA = 2;
		}
	}
	
	public final static class TrustedDestination {
		public final static class Projections {
			public final static String[] FOR_ADDRESSBOOK_DISPLAY = {
				TrustedDestination.Keys.DISPLAY_NAME,
				TrustedDestination.Keys.EMAIL,
				TrustedDestination.Keys.CONTACT_PHOTO,
				TrustedDestination.Keys.KEYRING_ID,
				TrustedDestination.Keys.IS_DELETABLE,
				BaseColumns._ID
			};
		}
		
		public final static class Keys {
			public final static String EMAIL = "trustedDestinationEmail";
			public final static String KEYRING_ID = Crypto.Keyring.Keys.ID;
			public final static String URL = "trustedDestinationURL";
			public final static String DISPLAY_NAME = "trustedDestinationDisplayName";
			public final static String CONTACT_PHOTO = AddressBook.Keys.CONTACT_PHOTO;
			public final static String IS_DELETABLE = "trustedDestinationIsDeletable";
		}
	}
	
	public final static class Media {
		public final static class Keys {
			public final static String TYPE = "mediaType";
			public final static String ORIGINAL_HASH = "originalHash";
			public final static String ANNOTATED_HASH = "annotatedHash";
			public final static String METADATA = "informaCamMetadata";
			public final static String LOCATION_OF_ORIGINAL = "locationOfOriginalMedia";
			public final static String LOCATION_OF_SENT = "locationOfSentMedia";
			public final static String TRUSTED_DESTINATION_ID = "trustedDestinationId";
			public final static String TRUSTED_DESTINATION_URL = TrustedDestination.Keys.URL;
			public final static String TRUSTED_DESTINATION_KEYRING_ID = TrustedDestination.Keys.KEYRING_ID;
			public final static String TRUSTED_DESTINATION_EMAIL = TrustedDestination.Keys.EMAIL;
			public final static String SHARE_VECTOR = "shareVector";
			public final static String MESSAGE_URL = "messageUrl";
			public final static String STATUS = "transitStatus";
			public final static String AUTH_TOKEN = "auth_token";
			public final static String ALIAS = "mediaAlias";
			public static final String TIME_CAPTURED = Informa.CaptureEvent.Keys.MEDIA_CAPTURE_COMPLETE;
			public static final String J3M_BASE = "j3mBase";
			public static final String J3M_MANIFEST = "j3mManifest";
			public static final String DERIVATIVE_ROOT = Transport.Manifest.Keys.DERIVATIVE_ROOT;
		}
		
		public final static class DateFormats {
			public static final String EXPORT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
			public static final String EXIF_DATE_FORMAT = "yyyy:MM:dd HH:mm:ss";
		}
		
		public final static class Type {
			public final static String MP4 = ".mp4";
			public final static String MKV = ".mkv";
			public final static String JPEG = ".jpg";
			public final static String MIME_TYPE_JPEG = "image/jpeg";
			public final static String MIME_TYPE_MP4 = "video/mp4";
			public final static String MIME_TYPE_MKV = "video/mkv";
			public final static String J3M_TORRENT = J3M.TORRENT_MIME_TYPE;
			public static final String ICTD = ".ictd";
			public static final String XML = ".xml";
			
			public final static int IMAGE = 400;
			public final static int VIDEO = 401;
			public final static Map<Integer, String> Names = new HashMap<Integer, String>();
			
			static {
				Names.put(IMAGE, "Image");
				Names.put(VIDEO, "Video");
			}
		}
		
		public final static class Status {
			public final static int IDLE = 1029;
			public final static int UPLOADING = 1030;
			public final static int UPLOAD_COMPLETE = 1031;
			public final static int UPLOAD_FAILED = 1032;
			public final static int NEVER_SCHEDULED_FOR_UPLOAD = 1033;
			public final static int BASE_IMAGE_REQUIRED = 1034;
		}
		
		public final static class Manifest {
			public final static class Keys {
				public final static String MEDIA_TYPE = Media.Keys.TYPE;
				public final static String LAST_SAVED = "lastSaved";
				public final static String ALIAS = Media.Keys.ALIAS;
				public final static String TIME_CAPTURED = Media.Keys.TIME_CAPTURED;
				public final static String SIZE = "mediaSize";
				public final static String LOCATION_OF_ORIGINAL = Media.Keys.LOCATION_OF_ORIGINAL;
				public final static String DURATION = Informa.Keys.Data.Exif.DURATION;
				public final static String LENGTH = Informa.Keys.Data.Exif.IMAGE_LENGTH;
				public final static String WIDTH = Informa.Keys.Data.Exif.IMAGE_WIDTH;
				public static final String AUTH_TOKEN = Transport.Manifest.Keys.AUTH_TOKEN;
				public static final String LAST_TRANSFERRED = Transport.Manifest.Keys.LAST_TRANSFERRED;
				public static final String TOTAL_CHUNKS = "totalJ3MChunks";
				public static final String URL = TrustedDestination.Keys.URL;
				public static final String CERTS = Transport.Keys.CERTS;
				public static final String THUMBNAIL = "mediaThumbnail";
				public static final String FINGERPRINT = Crypto.Keyring.Keys.FINGERPRINT;
				public static final String J3MBASE = Transport.Manifest.Keys.J3MBase;
				public static final String LAST_MESSAGES = "lastCheckedForMessages";
				public static final String TRUSTED_DESTINATION_DISPLAY_NAME = TrustedDestination.Keys.DISPLAY_NAME;
				public static final String DERIVATIVE_ROOT = Media.Keys.DERIVATIVE_ROOT;
				public static final String SHOULD_RETRY = "shouldRetryUpload";
				public static final String WHOLE_UPLOAD = J3M.Metadata.WHOLE_UPLOAD;
				public static final String WHOLE_UPLOAD_PATH = "whole_upload_path";
			}

			public static final String UPLOADED_FLAG = "uploadedFlag";
		}

		public static final String LOG = "**************** InformaCam:Media Services ****************";;
	}
	
	public final static class Settings {
		public static final String LOG = "**************** InformaCam:Settings ****************";
		
		public static final class Uploader {
			public final static String MODE = "informa.UploadMode";
		}
		
		public static final class Keys {
			public final static String CURRENT_LOGIN = "currentLogIn";
			public final static String EULA_ACCEPTED = "eulaAccepted";
			public final static String SETTINGS_VIEWED = "settingsViewed";
			public final static String LOGIN_CACHE_TIME = "loginCacheTime";
			public final static String DEFAULT_IMAGE_HANDLING = "defaultImageHandling";
			public final static String USE_ENCRYPTION = "useEncryption";
			public final static String USE_PROXY = "useProxy";
			public final static String DISPLAY_NAME = Informa.Keys.Owner.DISPLAY_NAME;
			public final static String DEVICE_EMAIL = "ownerEmailAddress";
			public static final String GLOBAL_TIME = "globalTimeFromDevice";
			public static final String DCIM_MANAGEMENT_TYPE = "dcimManagementType";
			public static final String UPLOADER_MODE = Settings.Uploader.MODE;
			public static final String LANGUAGE = "obscura.Language";
		}
		
		public final static class Device {
			public static final class Keys {
				public final static String KEYRING_ID = Crypto.PGP.Keys.PGP_KEY_ID;
				public final static String SECRET_KEY = "deviceSecretKey";
				public final static String AUTH_KEY = "deviceAuthKey";
				public final static String BASE_IMAGE = "deviceBaseImage";
				public static final String DCIM_MAP = "dcimMap";
			}
			
			public static final String[] OVERRIDE_EXTRA_OUTPUT_VIDEO = {
				"YP-G70",
				"YP-G1"
			};
			
			public static final String[] OVERRIDE_EXTRA_OUTPUT_IMAGE = {
				
			};
		}
		
		public final static class Login {
			public final static String PW_EXPIRY = "1839****PW_is139Expired(*)@";
		}
		
		public final static class LoginCache {
			public final static int ALWAYS = 200;
			public final static int AFTER_SAVE = 201;
			public final static int ON_CLOSE = 202;
		}
		
		public final static class OriginalImageHandling {
			public final static int LEAVE_ORIGINAL_ALONE = 300;
			public final static int ENCRYPT_ORIGINAL = 301;
			public final static int DELETE_ORIGINAL = 302;
		}

		public static int Translate(Preference preference) {
			// TODO Auto-generated method stub
			int value = 0;
			Log.d(Settings.LOG, "pref class: " + preference.getClass().getName());
			if(preference instanceof ListPreference) {
				String index = ((ListPreference) preference).getValue();
				for(int i=0; i<((ListPreference) preference).getEntryValues().length; i++) {
					Log.d(Settings.LOG, "index: " + index + "\nval: " + ((ListPreference) preference).getEntryValues()[i]);
					if(((ListPreference) preference).getEntryValues()[i].equals(index)) {
						value = i;
						break;
					}
				}
			}
			
			return value;
		}
	}
	
	public final static class Suckers {
		public static final String LOG = "**************** InformaCam:Suckers ****************";
		
		public static final class Keys {
			public static final String SIGNATURE = Crypto.Signatures.Keys.SIGNATURE;
			public static final String TIMESTAMP = Informa.CaptureEvent.Keys.TIMESTAMP;
		}
		
		public static final class Broadcasts {
			public final static String START = "startSuckerService";
			public final static String LOCK_LOGS = "lockLogs";
			public final static String UNLOCK_LOGS = "unlockLogs";
		}
		
		public static final class Accelerometer {
			public final static long LOG_RATE = 500L;
			
			public static final class Keys {
				public static final String ACC = "acc";
				public static final String ORIENTATION = "orientation";
				public static final String LIGHT = "light";
				public static final String LIGHT_METER_VALUE = "lightMeterValue";
				public static final String X = "acc_x";
				public static final String Y = "acc_y";
				public static final String Z = "acc_z";
				public static final String PITCH = "pitch";
				public static final String ROLL = "roll";
				public static final String AZIMUTH = "azimuth";
			}
		}
		
		public static final class Phone {
			public final static long LOG_RATE = 20000L;
			
			public static final class Keys {
				public static final String CELL_ID = "cellTowerId";
				public static final String BLUETOOTH_DEVICE_ADDRESS = "bluetoothDeviceAddress";
				public static final String BLUETOOTH_DEVICE_NAME = "bluetoothDeviceName";
				public static final String IMEI = "IMEI";
				public static final String VISIBLE_WIFI_NETWORKS = "visibleWifiNetworks";
				public static final String BSSID = "bssid";
				public static final String SSID = "ssid";
				
			}
		}
		
		public static final class Geo {
			public final static long LOG_RATE = 10000L;
			
			public static final class Keys {
				public static final String GPS_COORDS = "gps_coords";
			}
		}
	}
	
	public final static class Informa {
		public static final String LOG = "**************** InformaCam:Informa ****************";
		
		public final static int FROM_NOTIFICATION_BAR = 1074;
		
		public final static class Status {
			public final static int RUNNING = 0;
			public final static int STOPPED = 1;
			public final static int UPLOADING = 2;
		}
		
		public final static class Consent {
			public final static int GENERAL = 101;
		}
		
		public final static class Device {
			public final static int IS_SELF = -1;
			public final static int IS_NEIGHBOR = 1;
			public final static String SELF = "_self";
		}
		
		public final static class Genealogy {
			public final static class MediaOrigin {
				public final static int IMPORT = 400;
				public final static int FROM_INFORMA = 401;
			}
		}
		
		public final static class Owner {
			public final static int INDIVIDUAL = 400;
		}
		
		public final static class VideoRegions {
			public final static class Parent {
				public final static int SELF = -1;
			}
		}
		
		public final static class CaptureEvent {
			public final static int METADATA_CAPTURED = 272;
			public final static int MEDIA_OPENED = 273;
			public final static int REGION_GENERATED = 274;
			public final static int MEDIA_SAVED = 275;
			public final static int SENSOR_PLAYBACK = 271;
			public final static int TIMESTAMPS_RESOLVED= 270;
			
			public final static class Keys {
				public final static String USER_ACTION = "userActionReported";
				public final static String TYPE = "captureEventType";
				public final static String MATCH_TIMESTAMP = "captureEventMatchTimestamp";
				public final static String TIMESTAMP = "captureEventTimestamp";
				public final static String ON_VIDEO_START = "timestampOnVideoStart";
				public final static String MEDIA_CAPTURE_COMPLETE = "mediaCapturedComplete";
				public final static String METADATA_CAPTURED = "metadataCaptured";
			}
		}
		
		public static final class Keys {
			public final static String INTENT = "intent";
			public final static String GENEALOGY = "genealogy";
			public final static String DATA = "data";
			public static final int NOT_REPORTED = -100;
			
			
			public static final class Intent {
				public final static String TRUSTED_DESTINATION = TrustedDestination.Keys.EMAIL;
				public static final String ENCRYPT_LIST = "encryptionList";
			}
			
			public static final class Genealogy {
				public final static String LOCAL_MEDIA_PATH = Media.Keys.LOCATION_OF_ORIGINAL;
				public final static String DATE_CREATED = "dateCreated";
				public final static String MEDIA_ORIGIN = "mediaOrigin";
			}
			
			public static final class Device {
				public final static String LOCAL_TIMESTAMP = "deviceLocalTimestamp";
				public final static String PUBLIC_TIMESTAMP = "devicePublicTimestamp";
				public final static String DISPLAY_NAME = Keys.Owner.DISPLAY_NAME;
			}
			
			public static final class Owner {
				public final static String DISPLAY_NAME = "ownerName";
			}
			
			public static final class Data {
				public static final class Description {
					public final static String IMAGE_REGIONS = "imageRegions";
					public final static String VIDEO_REGIONS = "videoRegions";
					public final static String EVENTS = "events";
					public final static String ORIGINAL_HASH = Media.Keys.ORIGINAL_HASH;
					public final static String ANNOTATED_HASH = Media.Keys.ANNOTATED_HASH;
					public final static String EXIF = "exif";
					public final static String LOCATIONS = "location";
					public final static String CORROBORATION = "corroboration";
					public final static String CAPTURE_TIMESTAMPS = "captureTimestamp";
					public final static String MEDIA_TYPE = Media.Keys.TYPE;
				}
				
				public final static class Exif {
					public final static String MAKE = ExifInterface.TAG_MAKE;
					public final static String MODEL = ExifInterface.TAG_MODEL;
					public final static String APERTURE = ExifInterface.TAG_APERTURE;
					public final static String FLASH = ExifInterface.TAG_FLASH;
					public final static String EXPOSURE = ExifInterface.TAG_EXPOSURE_TIME;
					public final static String FOCAL_LENGTH = ExifInterface.TAG_FOCAL_LENGTH;
					public final static String IMAGE_WIDTH = ExifInterface.TAG_IMAGE_WIDTH;
					public final static String IMAGE_LENGTH = ExifInterface.TAG_IMAGE_LENGTH;
					public final static String ISO = ExifInterface.TAG_ISO;
					public final static String ORIENTATION = ExifInterface.TAG_ORIENTATION;
					public final static String WHITE_BALANCE = ExifInterface.TAG_WHITE_BALANCE;
					public final static String TIMESTAMP = ExifInterface.TAG_DATETIME;
					public final static String DURATION = "duration";
					public static final String TITLE = "title";
					public static final String DESCRIPTION = "description";
					
				}
				
				public static final class ImageRegion {
					public final static String INDEX = "regionIndex";
					public final static String THUMBNAIL = "regionThumbnail";
					public static final String DATA = "region_data";
					public final static String TIMESTAMP = "timestampOnGeneration";
					public final static String LOCATION = "locationOnGeneration";
					public final static String TAGGER_RETURN = "taggerReturned";
					public final static String FILTER = "obfuscationType";
					public final static String COORDINATES = "regionCoordinates";
					public final static String DIMENSIONS = "regionDimensions";
					public final static String WIDTH = "region_width";
					public final static String HEIGHT = "region_height";
					public final static String TOP = "region_top";
					public final static String LEFT = "region_left";
					public final static String UNREDACTED_DATA = "unredactedRegionData";
					public final static String BASE = "base";
					public final static String LENGTH = "imageRegionByteLength";
					public final static String BYTES = "imageRegionBytes";
					public final static String HASH = "imageRegionHash";
					
					public final static class Subject {
						public final static String FORM_NAMESPACE = "form_namespace";
						public static final String FORM_DATA = "form_data";
						public static final String FORM_DEF_PATH = "formDefPath";
						
						public static final String[] OmitWhileUpdating = {
							FORM_NAMESPACE,
							FORM_DEF_PATH,
							FORM_DATA,
							Form.Extras.DEFAULT_THUMB,
							Form.Extras.EXPORT_MODE,
							Form.Extras.MAX_QUESTIONS_PER_PAGE,
							Form.Extras.DATA_DUMP
						};
					}
				}
				
				public static final class VideoRegion {
					public final static String INDEX = Informa.Keys.Data.ImageRegion.INDEX;
					public final static String THUMBNAIL = Informa.Keys.Data.ImageRegion.THUMBNAIL;
					public static final String DATA = Informa.Keys.Data.ImageRegion.DATA;
					public final static String TIMESTAMP = Informa.Keys.Data.ImageRegion.TIMESTAMP;
					public final static String LOCATION = Informa.Keys.Data.ImageRegion.LOCATION;
					public final static String TAGGER_RETURN = Informa.Keys.Data.ImageRegion.TAGGER_RETURN;
					public final static String FILTER = Informa.Keys.Data.ImageRegion.FILTER;
					public final static String UNREDACTED_DATA = Informa.Keys.Data.ImageRegion.UNREDACTED_DATA;
					public final static String BASE = Informa.Keys.Data.ImageRegion.BASE;
					public static final String START_TIME = "videoStartTime";
					public static final String END_TIME = "videoEndTime";
					public static final String CHILD_REGIONS = "videoChildRegions";
					public static final String TRAIL = "videoTrail";
					public static final String PROPERTIES = "videoProperties";
					
					public final static class Child {
						public final static String COORDINATES = Informa.Keys.Data.ImageRegion.COORDINATES;
						public final static String DIMENSIONS = Informa.Keys.Data.ImageRegion.DIMENSIONS;
						public final static String WIDTH = Informa.Keys.Data.ImageRegion.WIDTH;
						public final static String HEIGHT = Informa.Keys.Data.ImageRegion.HEIGHT;
						public final static String TOP = Informa.Keys.Data.ImageRegion.TOP;
						public final static String LEFT = Informa.Keys.Data.ImageRegion.LEFT;
						public static final String TIMESTAMP = "regionTimestamp";
					}
					
					public final static class Subject {
						public final static String FORM_NAMESPACE = Informa.Keys.Data.ImageRegion.Subject.FORM_NAMESPACE;
						public static final String FORM_DATA = Informa.Keys.Data.ImageRegion.Subject.FORM_DATA;
						public static final String FORM_DEF_PATH = Informa.Keys.Data.ImageRegion.Subject.FORM_DEF_PATH;
					}
				}
			}
		}
	}
	
	public final static class Storage {
		public static final String LOG = "**************** InformaCam:Storage ****************";
		
		public final static class Tables {
			public final static class Keys {
				public static final String MEDIA = "informaCamMedia";
				public static final String CONTACTS = "informaCamContacts";
				public static final String SETUP = "informaCamSetup";
				public static final String TRUSTED_DESTINATIONS = "informaCamTrustedDestinations";
				public static final String KEYRING = "informaCamKeyring";
				public static final String KEYSTORE = "informaCamKeystore";
			}
		}
		
		public final static class FileIO {
			public final static String DUMP_FOLDER = Environment.getExternalStorageDirectory() + "/InformaCam";
			public final static String IMAGE_TMP = "informa_tmp.jpg";
			public final static String VIDEO_TMP = "informa_tmp.mp4";
			public final static String TMP_VIDEO_DATA_FILE_NAME = "informaCam_metadata.json";
			public static final String ICTD_TEMP = "informacam.ictd";
			public static final String DATA_DUMP = DUMP_FOLDER + "/data/";
		}
		
		public final static class IOCipher {
			public final static String STORE = "iocipher.db";
			public static final String ROOT = "informaCamIoCipher";
			public static final String DUMP_FOLDER = "informaCam";
			public static final String FORM_ROOT = "installed_forms";
			public final static String[] RESERVED_FOLDERS = {
				"informaCam",
				"installed_forms"
			};
			
		}
		
		public final static class ICTD {
			public final static List<String> ZIP_OMITABLES;
			static {
				List<String> zip_omitables = new ArrayList<String>();
				zip_omitables.add("__MACOSX");
				zip_omitables.add("DS_Store");
				ZIP_OMITABLES = Collections.unmodifiableList(zip_omitables);
			}
		}
	}
	
	public final static class Uploader {
		public static final String LOG = "**************** InformaCam:Uploader ****************";
		
		public static final class Broadcasts {
			public final static String AVAILABLE = "uploaderAvailable";
			public final static String START = "startUploaderService";
		}
		
		public static final class Keys {
			public final static String CLIENT_PGP = Crypto.PGP.Keys.PGP_FINGERPRINT;
			public final static String TIMESTAMP_CREATED = Informa.Keys.Genealogy.DATE_CREATED;
			public final static String MEDIA_TYPE = Media.Keys.TYPE;
			public final static String ORIGINAL_HASH = Media.Keys.ORIGINAL_HASH;
			public final static String BYTES_EXPECTED = "totalBytesExpected";
			public final static String ZIPPED_BYTES_EXPECTED = "zippedBytesExpected";
			public final static String ZIPPED_HASH = "zippedHash";
			
			public final static String BYTES_TRANSFERED = "bytesTransfered";
			public final static String LAST_BYTE_TRANSFERED = "lastByteTransfered";
			
			public final static String UPLOAD_ATTEMPTS = "uploadAttempts";
			public static final String J3M = "j3m";
			public static final String AUTH_TOKEN = Media.Keys.AUTH_TOKEN;
			public static final String CHECK_FOR_MISSING_TORRENTS = "checkForMissingTorrents";
			public static final String SUPPORTING_DATA = "supportingData";
			public static final String WHOLE_UPLOAD = "whole_upload";
		}
		
		public static final class Status {
			public final static int TICKET_REQUESTED = 375;
			public final static int TICKET_RECEIVED = 374;
			
		}
	}
	
	public final static class Crypto {
		public static final String LOG = "**************** InformaCam:Crypto ****************";
		
		public final static class Signatures {
			public final static class Keys {
				public final static String SIGNATURE = "dataSignature";
			}
		}
		
		public final static class Keyring {
			public final static class Keys {
				public final static String ID = PGP.Keys.PGP_KEY_ID;
				public final static String PUBLIC_KEY = "trustedDestinationPublicKey";
				public final static String FINGERPRINT = PGP.Keys.PGP_FINGERPRINT;
				public final static String TRUSTED_DESTINATION_ID = "trustedDestinationId";
				public static final String ALGORITHM = "keyAlgorithm";
			}
		}
		
		public final static class Keystore {
			public final static class Keys {
				public final static String CERTS = "certs";
				public final static String TIME_MODIFIED = "timeModified";
				public static final String PASSWORD = "password";
			}
		}
		
		public final static class PGP {
			public final static String[] keyserverUrl = {
				"http://keyserver.kjsl.org:11371/pks/lookup?op=get&search="
			};
			
			public final static String[] beginKeyBlock = {
				"-----BEGIN PGP PUBLIC KEY BLOCK-----"
			};
			
			public final static String[] endKeyBlock = {
				"-----END PGP PUBLIC KEY BLOCK-----"
			};
			
			public static final class Keys {
				public final static String PGP_KEY_ID = "pgpKeyId";
				public final static String PGP_FINGERPRINT = "pgpKeyFingerprint";
				public final static String PGP_CREATION_DATE = "pgpCreationDate";
				public final static String PGP_EXPIRY_DATE = "pgpExpiryDate";
				public final static String PGP_EMAIL_ADDRESS = "pgpEmailAddress";
				public final static String PGP_DISPLAY_NAME = "pgpDisplayName";
				public final static String PGP_KEY_IS_TRUSTED = "pgpKeyIsTrusted";
				public final static String PGP_PUBLIC_KEY = Crypto.Keyring.Keys.PUBLIC_KEY;
			}
		}
	}
	
	public final static class Transport {
		public static final String LOG = "**************** InformaCam:TRANSPORT ****************";
		public static final class Errors {
			public static final String CONNECTION = "connectionError";
		}
		
		public final static class Result {
			public final static String OK = "A_OK";
			public final static String FAIL = "FAIL";
			public final static class ErrorCodes {
				public final static int AUTH_FAILURE = 1998;
				public final static int DUPLICATE_J3M_TORRENT = 2000;
				public final static int COULD_NOT_CREATE_FOLDER = 1999;
				public final static int BASE_IMAGE_REQUIRED = 1995;
				public final static int PGP_KEY_REQUIRED = 1996;
				public final static int NO_UPLOADS_MISSING = 1997;
			}
		}
		
		public final static class Keys {
			public final static String HYPHENS = "--";
			public final static String BOUNDARY = "*****InformaCamData****";
			public final static String LINE_END = "\r\n";
			public static final String RESULT = "result";
			public static final String BUNDLE = "bundle";
			public final static String RES = "res";
			public static final String URL = TrustedDestination.Keys.URL;
			public static final String CERTS = Crypto.Keystore.Keys.CERTS;
			public static final String ERROR_CODE = "error_code";
			public static final String MISSING_TORRENTS = "missingTorrents";
			public static final String GET_MESSAGES = "getMessages";
			public static final String MESSAGES = "messages";
			public static final String BASE_IMAGE = "baseImage";
			public static final String PGP_KEY_ENCODED = "pgpKeyEncoded";
			public static final String REQUIREMENTS = "requirements";
			public static final String GET_REQUIREMENTS = "getRequirements";
			public static final String SUPPORTED_DATA_REQUIRED = "supportingDataRequired";
			public static final String READ_ARRAY = "readArray";
			public static final String CLIENT_PGP = Uploader.Keys.CLIENT_PGP;
			public static final String PUT_MESSAGE = "putNewMessage";
			
			public static final class Message {
				public static final String CONTENT = "content";
				public static final String URL = "url";
			}
			
		}

		public final static class Manifest {
			public final static class Keys {
				public static final String DERIVATIVE_ROOT = Media.Keys.ORIGINAL_HASH;
				public static final String LAST_TRANSFERRED = "lastJ3MTorrent";
				public static final String AUTH_TOKEN = "auth_token";
				public static final String TOTAL_CHUNKS = Media.Manifest.Keys.TOTAL_CHUNKS;
				public static final String J3MBase = Media.Keys.J3M_BASE;
				public static final String TRUSTED_DESTINATION_DISPLAY_NAME = Media.Manifest.Keys.TRUSTED_DESTINATION_DISPLAY_NAME;
			}
		}

		public static class MimeTypes {
			public static final String JSON = "application/json";
			public static final String TEXT = "text/plain";
			public static final String OCTET_STREAM = "application/octet-stream";
		}
		
		
		
	}
	
	public final static class J3M {
		public static final String LOG = "**************** InformaCam:J3M ****************";
		public static final String ACTION = "j3m_action";
		
		public final static class Chunks {
			public final static int EXTRA_SMALL = 64;
			public final static int SMALL = 1024;
			public final static int MEDIUM = 4096;
			public final static int LARGE = 12288;
			public final static int EXTRA_LARGE = 36864;
			public static final int EXTRA_EXTRA_LARGE = 100000;
			public static final int EXTRA_EXTRA_EXTRA_LARGE = 250000;
			public static final int WHOLE = -1;
		}
		
		public static final Map<Integer, Integer> CHUNKS;
		static {
			Map<Integer, Integer> chunks = new HashMap<Integer, Integer>();
			chunks.put(Chunks.WHOLE, -1);
			chunks.put(Chunks.EXTRA_EXTRA_EXTRA_LARGE, 600);
			chunks.put(Chunks.EXTRA_LARGE, 601);
			chunks.put(Chunks.MEDIUM, 602);
			chunks.put(Chunks.SMALL, 603);
			CHUNKS = Collections.unmodifiableMap(chunks);
		}
		
		public final static class Keys {
			public final static String DESCRIPTOR = "j3m_descriptor";
			public final static String PACKAGE = "j3m_package";
			public static final String FINGERPRINT = Crypto.Keyring.Keys.FINGERPRINT;
			public static final String PKCS12_ID = Transport.Keys.CERTS;
			public static final String URL = TrustedDestination.Keys.URL;
			public static final String ROOT = Media.Manifest.Keys.J3MBASE;
			public static final String DERIVATIVE_ROOT = Media.Manifest.Keys.DERIVATIVE_ROOT;
			public static final String THUMBNAIL = Media.Manifest.Keys.THUMBNAIL;
			public static final String DISPLAY_NAME = Media.Manifest.Keys.ALIAS;
			public static final String NUM_CHUNKS = Metadata.NUM_CHUNKS;
			public static final String AUTH_TOKEN = Media.Manifest.Keys.AUTH_TOKEN;
			
			
		}
		
		public final static String TORRENT_MIME_TYPE = ".j3mtorrent";
		public static final String DUMP_FOLDER = "j3m";
		public static final String TORRENT_DESCRIPTOR_MIME_TYPE = ".j3mdescriptor";
		public static final String TORRENT_PACKAGE_MIME_TYPE = ".j3mpackage";
		
		public final static class State {
			public static final int IS_IDLE = 0;
	    	public static final int IS_JEMIFYING = 1;
	    	public static final int IS_JEMIFIED = 2;
		}
		
		public final static class Metadata {
			public static final String SOURCE = "chunk_source";
	    	public static final String INDEX = "chunk_index";
	    	public static final String LENGTH = "chunk_length";
	    	public static final String ENCRYPTION = "encryption";
	    	public static final String BLOB = "blob";
			public static final String NUM_CHUNKS = "num_chunks";
			public static final String WHOLE_UPLOAD = "whole_upload";
		}
	}

	public static final class Forms {
		public final static String LOG = "**************** InformaCam: FORMS ****************";
		public static final String TITLE = "form_title";
		public static final String DEF = "formdef_path";
	}
}
