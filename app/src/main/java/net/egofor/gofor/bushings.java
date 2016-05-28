package net.egofor.gofor;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.geo.GeoPoint;
import com.backendless.persistence.BackendlessDataQuery;

public class bushings
{
  private String _diameter;
  private String _thumbnail;
  private String _height;
  private java.util.Date updated;
  private String _upc;
  private String _short_description;
  private String _temerature_rating;
  private String _application;
  private String _wire_size;
  private String objectId;
  private String _lug;
  private java.util.Date created;
  private String _bushing_type;
  private String _mfg;
  private String _mfg_part_number;
  private String _conductor_material;
  private String _trade_size;
  private String _material;
  private String _thread_length;
  private String _insulated;
  private String _installation;
  private String ownerId;
  public String get_diameter()
  {
    return _diameter;
  }

  public void set_diameter( String _diameter )
  {
    this._diameter = _diameter;
  }

  public String get_thumbnail()
  {
    return _thumbnail;
  }

  public void set_thumbnail( String _thumbnail )
  {
    this._thumbnail = _thumbnail;
  }

  public String get_height()
  {
    return _height;
  }

  public void set_height( String _height )
  {
    this._height = _height;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

  public String get_upc()
  {
    return _upc;
  }

  public void set_upc( String _upc )
  {
    this._upc = _upc;
  }

  public String get_short_description()
  {
    return _short_description;
  }

  public void set_short_description( String _short_description )
  {
    this._short_description = _short_description;
  }

  public String get_temerature_rating()
  {
    return _temerature_rating;
  }

  public void set_temerature_rating( String _temerature_rating )
  {
    this._temerature_rating = _temerature_rating;
  }

  public String get_application()
  {
    return _application;
  }

  public void set_application( String _application )
  {
    this._application = _application;
  }

  public String get_wire_size()
  {
    return _wire_size;
  }

  public void set_wire_size( String _wire_size )
  {
    this._wire_size = _wire_size;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public String get_lug()
  {
    return _lug;
  }

  public void set_lug( String _lug )
  {
    this._lug = _lug;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public String get_bushing_type()
  {
    return _bushing_type;
  }

  public void set_bushing_type( String _bushing_type )
  {
    this._bushing_type = _bushing_type;
  }

  public String get_mfg()
  {
    return _mfg;
  }

  public void set_mfg( String _mfg )
  {
    this._mfg = _mfg;
  }

  public String get_mfg_part_number()
  {
    return _mfg_part_number;
  }

  public void set_mfg_part_number( String _mfg_part_number )
  {
    this._mfg_part_number = _mfg_part_number;
  }

  public String get_conductor_material()
  {
    return _conductor_material;
  }

  public void set_conductor_material( String _conductor_material )
  {
    this._conductor_material = _conductor_material;
  }

  public String get_trade_size()
  {
    return _trade_size;
  }

  public void set_trade_size( String _trade_size )
  {
    this._trade_size = _trade_size;
  }

  public String get_material()
  {
    return _material;
  }

  public void set_material( String _material )
  {
    this._material = _material;
  }

  public String get_thread_length()
  {
    return _thread_length;
  }

  public void set_thread_length( String _thread_length )
  {
    this._thread_length = _thread_length;
  }

  public String get_insulated()
  {
    return _insulated;
  }

  public void set_insulated( String _insulated )
  {
    this._insulated = _insulated;
  }

  public String get_installation()
  {
    return _installation;
  }

  public void set_installation( String _installation )
  {
    this._installation = _installation;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

                                                    
  public bushings save()
  {
    return Backendless.Data.of( bushings.class ).save( this );
  }

  public Future<bushings> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<bushings> future = new Future<bushings>();
      Backendless.Data.of( bushings.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<bushings> callback )
  {
    Backendless.Data.of( bushings.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( bushings.class ).remove( this );
  }

  public Future<Long> removeAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Long> future = new Future<Long>();
      Backendless.Data.of( bushings.class ).remove( this, future );

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( bushings.class ).remove( this, callback );
  }

  public static bushings findById( String id )
  {
    return Backendless.Data.of( bushings.class ).findById( id );
  }

  public static Future<bushings> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<bushings> future = new Future<bushings>();
      Backendless.Data.of( bushings.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<bushings> callback )
  {
    Backendless.Data.of( bushings.class ).findById( id, callback );
  }

  public static bushings findFirst()
  {
    return Backendless.Data.of( bushings.class ).findFirst();
  }

  public static Future<bushings> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<bushings> future = new Future<bushings>();
      Backendless.Data.of( bushings.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<bushings> callback )
  {
    Backendless.Data.of( bushings.class ).findFirst( callback );
  }

  public static bushings findLast()
  {
    return Backendless.Data.of( bushings.class ).findLast();
  }

  public static Future<bushings> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<bushings> future = new Future<bushings>();
      Backendless.Data.of( bushings.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<bushings> callback )
  {
    Backendless.Data.of( bushings.class ).findLast( callback );
  }

  public static BackendlessCollection<bushings> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( bushings.class ).find( query );
  }

  public static Future<BackendlessCollection<bushings>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<bushings>> future = new Future<BackendlessCollection<bushings>>();
      Backendless.Data.of( bushings.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<bushings>> callback )
  {
    Backendless.Data.of( bushings.class ).find( query, callback );
  }
}